package com.yashdev.easyprefs;


//  Interface for saving or getting data from Preferences.
public interface EasyPrefs {

    void store(String key, Object toStore);

    // Getting data from Preferences using key as id.
    <T> T get(String key, T defaultObj);

    //  This deletes all the data previously saved in the Preferences.
    void reset();
}
