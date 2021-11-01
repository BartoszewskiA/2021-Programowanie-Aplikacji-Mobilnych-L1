package com.example.lab03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
            implements GestureDetector.OnGestureListener {


   EditText poleA, poleB, poleC;
   TextView poleWynik;
   Button przycisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poleA = findViewById(R.id.editText01);
        poleB = findViewById(R.id.editText02);
        poleC = findViewById(R.id.editText03);
        poleWynik = findViewById(R.id.textViewWynik);
        przycisk = findViewById(R.id.button01);
    }

    public void obliczenie(View view) {
        int a=0,b=0,c=0;
        String s;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        };

        przycisk.setOnClickListener(listener);


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        SeekBar seekBar = null;

        SeekBar.OnSeekBarChangeListener sluchacz = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //metoda wywoływana przy każdej zmianie pozycji suwaka
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //metoda wywoływana raz, przy rozpoczęciu przesuwania suwaka
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //metoda wywoływana raz, po zakończniu przesuwania suwaka
            }
        };
        seekBar.setOnSeekBarChangeListener(sluchacz);


        s = poleA.getText().toString();
        if (s.length()>0 && !s.equals("-"))  //s == "-";
            a = Integer.parseInt(s);
        else
        {
            a=0;
            poleA.setText("0");
        }
        s = poleB.getText().toString();
        if (s.length()>0 && !s.equals("-"))  //s == "-";
            b = Integer.parseInt(s);
        else
        {
            b=0;
            poleB.setText("0");
        }
        s = poleC.getText().toString();
        if (s.length()>0 && !s.equals("-"))  //s == "-";
            c = Integer.parseInt(s);
        else
        {
            c=0;
            poleC.setText("0");
        }
         int delta = b*b - 4*a*c;
        String wynik="";

        if (delta >0)
        {
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            wynik+="delta = ";
            wynik+=String.valueOf(delta);
            wynik+="\n";
            wynik+="x1 = ";
            wynik+=String.valueOf(x1);
            wynik+="\n";
            wynik+="x2 = ";
            wynik+=String.valueOf(x2);
        }
        else if (delta == 0)
        {
            double x0 = (double)(-b)/(2*a);
            wynik+="delta = ";
            wynik+=String.valueOf(delta);
            wynik+="\n";
            wynik+="x0 = ";
            wynik+=String.valueOf(x0);
        }
        else
        {
            wynik+="delta = ";
            wynik+=String.valueOf(delta);
            wynik+="\n";
            wynik+="Brak rozwiązań";
        }
        poleWynik.setText(wynik);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }
    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }
    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}