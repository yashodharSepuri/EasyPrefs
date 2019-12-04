package com.yashdev.easyprefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class EasyPreferences implements EasyPrefs {

    private SharedPreferences mSp;
    private Gson mGson;

    private EasyPreferences() {
        mGson = new Gson();
    }

    public EasyPreferences(Context context, String name, int type) {
        this();
        mSp = context.getApplicationContext().getSharedPreferences(name, type);
    }

    public EasyPreferences(Context context, String name) {
        this(context, name, Context.MODE_PRIVATE);
    }

    @Override
    public void store(String key, Object toStore) {
        final SharedPreferences.Editor editor = mSp.edit();
        storeObject(editor, key, toStore);
        editor.apply();
    }

    @SuppressWarnings("unchecked") // it is managed
    @Override
    public <T> T get(String key, T defaultObj) {
        Object result;
        if (defaultObj instanceof String) {
            result = mSp.getString(key, (String) defaultObj);
        } else if (defaultObj instanceof Boolean) {
            result = mSp.getBoolean(key, (Boolean) defaultObj);
        } else if (defaultObj instanceof Float) {
            result = mSp.getFloat(key, (Float) defaultObj);
        } else if (defaultObj instanceof Long) {
            result = mSp.getLong(key, (Long) defaultObj);
        } else if (defaultObj instanceof Integer) {
            result = mSp.getInt(key, (Integer) defaultObj);
        } else {
            T object = deserializeFromSp(key, defaultObj);
            result = (object == null ? defaultObj : object);
        }
        // the API for Sets is not used due to compatibility reasons
        // and to provide a nicer API. In fact, to use it, two separate method
        // would be necessary.
        return (T) result;
    }

    private void storeObject(SharedPreferences.Editor editor, String key, Object toStore) {
        if (toStore instanceof String) {
            editor.putString(key, (String) toStore);
        } else if (toStore instanceof Boolean) {
            editor.putBoolean(key, (Boolean) toStore);
        } else if (toStore instanceof Float) {
            editor.putFloat(key, (Float) toStore);
        } else if (toStore instanceof Long) {
            editor.putLong(key, (Long) toStore);
        } else if (toStore instanceof Integer) {
            editor.putInt(key, (Integer) toStore);
        } else {
            String json = serializeObject(editor, key, toStore);
            editor.putString(key, json);
        }
    }

    @Override
    public void reset() {
        mSp.edit().clear().apply();
    }

    private String serializeObject(SharedPreferences.Editor editor, String key, Object toStore) {
        return mGson.toJson(toStore);
    }

    private <T> T deserializeFromSp(String key, T defaultObj) {
        String json = mSp.getString(key, null);
        if (json == null) {
            return null;
        }
        return (T) mGson.fromJson(json, defaultObj.getClass());
    }
}
