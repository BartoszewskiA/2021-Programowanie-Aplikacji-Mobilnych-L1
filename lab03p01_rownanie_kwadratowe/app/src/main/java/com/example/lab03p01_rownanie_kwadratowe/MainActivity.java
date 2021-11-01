package com.example.lab03p01_rownanie_kwadratowe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText poleA, poleB,poleC;
    TextView poleWynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poleA = findViewById(R.id.editText01);
        poleB = findViewById(R.id.editText02);
        poleC = findViewById(R.id.editText03);
        poleWynik = findViewById(R.id.textViewWynik);
    }

    public void obliczenie(View view) {
        String s;
        int a, b, c;
        s = poleA.getText().toString();
        if (s.length() > 0)
            a = Integer.parseInt(s);
        else {
            poleA.setText("0");
            a = 0;
        }
        s = poleB.getText().toString();
        if (s.length() > 0)
            b = Integer.parseInt(s);
        else {
            poleB.setText("0");
            b = 0;
        }
        s = poleC.getText().toString();
        if (s.length() > 0)
            c = Integer.parseInt(s);
        else {
            poleC.setText("0");
            c = 0;
        }
        String wynik = "";
        int delta = b * b - 4 * a * c;
        if (delta > 0) {
            Double x1 = (-b - Math.sqrt(delta) / (2 * a));
            Double x2 = (-b + Math.sqrt(delta) / (2 * a));
            wynik += "delta = ";
            wynik += String.valueOf(delta);
            wynik += "\n";
            wynik += "x1 = ";
            wynik += Double.toString(x1);
            wynik += "\n";
            wynik += "x2 = ";
            wynik += Double.toString(x2);
        } else if (delta == 0)
        {
            Double x0 = (double)(-b) / (2 * a);
            wynik += "delta = ";
            wynik += String.valueOf(delta);
            wynik += "\n";
            wynik += "x0 = ";
            wynik += Double.toString(x0);
        } else
        {
            wynik = "Brak rozwiązań";
        }
        poleWynik.setText(wynik);
    }



    }