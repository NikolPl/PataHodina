package com.example.nikol.patahodina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override // tohle se vygeneruje přes Code - override method App CompatActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tady začíná náš kod -> zakládáme novou instanci hawkButton, která je spojená pomocí ID v layoutou activityMain
        Button hawkButton = findViewById(R.id.hawkButton);
        Button sharedPrefButton = findViewById(R.id.sharedPrefButton);

        hawkButton.setOnClickListener(new View.OnClickListener() { // na instanci se nastaví poslouchač klepačů
            @Override
            public void onClick(View v) { // vytvoření přespání metody OnClick která startuje aktivituv spojenou s HawkActivity
                Intent intent = new Intent(MainActivity.this, HawkActivity.class);
                startActivity(intent);
            }
        });

        sharedPrefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPrefActivity.class);
                startActivity(intent);
            }
        });
    }
}
