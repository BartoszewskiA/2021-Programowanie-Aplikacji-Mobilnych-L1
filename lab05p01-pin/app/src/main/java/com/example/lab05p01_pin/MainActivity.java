package com.example.lab05p01_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button p0,p1,p2,p3,p4,p5,p6,p7,p8,p9;
    View.OnClickListener sluchacz;
    private String prawidlowyPIN="1234";
    private String PIN="";

    int[] tablicaMieszajaca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        odnajdzElementy();
        tablicaMieszajaca = new int[10];
        losujTablice();
        przypiszEtykietPrzyciskow();
        utworzSluchaczaZdarzen();
        dodajSluchaczaZdarzen();

    }

    private void przypiszEtykietPrzyciskow() {
        p0.setText(String.valueOf(tablicaMieszajaca[0]));
        p1.setText(String.valueOf(tablicaMieszajaca[1]));
        p2.setText(String.valueOf(tablicaMieszajaca[2]));
        p3.setText(String.valueOf(tablicaMieszajaca[3]));
        p4.setText(String.valueOf(tablicaMieszajaca[4]));
        p5.setText(String.valueOf(tablicaMieszajaca[5]));
        p6.setText(String.valueOf(tablicaMieszajaca[6]));
        p7.setText(String.valueOf(tablicaMieszajaca[7]));
        p8.setText(String.valueOf(tablicaMieszajaca[8]));
        p9.setText(String.valueOf(tablicaMieszajaca[9]));
    }

    private void utworzSluchaczaZdarzen() {
        sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = view.getId();
                switch(Id)
                {
                    case R.id.button00: dodajCyfreDoPinu(tablicaMieszajaca[0]); break;
                    case R.id.button01: break;
                }

            }
        };
    }

    private void dodajCyfreDoPinu(int cyfra) {

    }

    private void losujTablice() {
        Random random = new Random();
        for (int i=0;i<10;i++)
            tablicaMieszajaca[i]=random.nextInt(10);
    }

    private void odnajdzElementy() {
        p0 = findViewById(R.id.button00);
        p1 = findViewById(R.id.button01);
        p2 = findViewById(R.id.button02);
        p3 = findViewById(R.id.button03);
        p4 = findViewById(R.id.button04);
        p5 = findViewById(R.id.button05);
        p6 = findViewById(R.id.button06);
        p7 = findViewById(R.id.button07);
        p8 = findViewById(R.id.button08);
        p9 = findViewById(R.id.button09);
    }

    private void dodajSluchaczaZdarzen() {
        p0.setOnClickListener(sluchacz);
        p1.setOnClickListener(sluchacz);
        p2.setOnClickListener(sluchacz);
        p3.setOnClickListener(sluchacz);
        p4.setOnClickListener(sluchacz);
        p5.setOnClickListener(sluchacz);
        p6.setOnClickListener(sluchacz);
        p7.setOnClickListener(sluchacz);
        p8.setOnClickListener(sluchacz);
        p9.setOnClickListener(sluchacz);
    }
}