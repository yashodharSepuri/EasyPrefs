package com.yashdev.easyprefsdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yashdev.easyprefs.EasyPrefs;
import com.yashdev.easyprefs.EasyPreferences;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);

        // Initialization
        EasyPrefs easyPrefs = new EasyPreferences(this, "AppPrefs", MODE_PRIVATE);

        // Saving Data
        easyPrefs.store("string", "Hello World!");
        easyPrefs.store("boolean", true);
        easyPrefs.store("float", 93.232323f);
        easyPrefs.store("long", 987L);
        easyPrefs.store("int", 1);

        // Getting Data
        String string = easyPrefs.get("string", "No string");
        boolean aBoolean = easyPrefs.get("boolean", false);
        float aFloat = easyPrefs.get("float", 0f);
        long aLong = easyPrefs.get("long", 0L);
        int anInt = easyPrefs.get("int", 0);

        String text = String.format(Locale.getDefault(),
                "String Data : %s\n\nBoolean Data : %b\n\nFloat Data : %f\n\nLong Data : %d\n\nInt Data : %d\n\n",
                string, aBoolean, aFloat, aLong, anInt);

        // Delete the all Saved Data
        // easyPrefs.reset();

        textView.setTextSize(16);
        textView.setText(text);
    }
}
