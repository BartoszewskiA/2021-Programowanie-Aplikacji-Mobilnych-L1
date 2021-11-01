package com.example.lab01p01_atlasgrzybow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int poz=0;
    int[] zdjecia = new int[] {
            R.drawable.borowik,
            R.drawable.pieczarka,
            R.drawable.muchomor
    };
    String[] opisy;

    ImageView ramka;
    TextView opis;
    Button button_np, button_ws;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opisy = getResources().getStringArray(R.array.opisy_grzybow);
        ramka= findViewById(R.id.ramka);
        opis = findViewById(R.id.opis);
        button_np = findViewById(R.id.button_np);
        button_ws = findViewById(R.id.button_wstecz);
        ramka.setImageResource(zdjecia[poz]);
        opis.setText(opisy[poz]);

    }

    public void pezesun_np(View view) {
        poz++;
        if (poz > 2) poz=0;
        ramka.setImageResource(zdjecia[poz]);
        opis.setText(opisy[poz]);

    }

    public void przesun_ws(View view) {
        poz--;
        if (poz <0) poz=2;
        ramka.setImageResource(zdjecia[poz]);
        opis.setText(opisy[poz]);

    }
}