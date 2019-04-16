package com.example.nikol.patahodina;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefActivity extends AppCompatActivity {

    static String folder = "czechitasZkouska";
    static String dataName = "login"; // statické protože se to nebude měnit, login - to je jako klíč, pod kterým je uložen string
    private SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        // prefs je nějaký náš slovník, kam se to bude ukládat
        prefs = this.getSharedPreferences(folder, Context.MODE_PRIVATE); // privátní mod - nebudou se sharevoat ty data, která tam uložém
        final EditText input = findViewById(R.id.input);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                prefs.edit().putString(dataName, text).apply();
            }
        });

        input.setText(prefs.getString(dataName, ""));
    }
}
