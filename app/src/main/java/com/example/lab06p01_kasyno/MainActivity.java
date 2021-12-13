package com.example.lab06p01_kasyno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Spinner obstawiane;
    ImageView ramka;
    SeekBar suwak;
    TextView polePortfel, poleStawka;
    int rodzaGry = 0;   // 0 - parzyste
                        // 1 - nieparzste
                        // 2 - podzielne przez 3
                        // 3 - podzielne przez 5
    int[] obrazki = new int[] {R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4};
    int portfel = 100;
    int stawka = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obstawiane = findViewById(R.id.obstawiane);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                                                                            getResources().getStringArray(R.array.rodzajeStawek));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        obstawiane.setAdapter(adapter);


        ramka = findViewById(R.id.obrazek);
        ramka.setImageResource(obrazki[rodzaGry]);
        suwak = findViewById(R.id.suwak);
        polePortfel = findViewById(R.id.portfwel);
        poleStawka = findViewById(R.id.stawka);

        dodajSluchaczZdarzen();
    }

    private void dodajSluchaczZdarzen() {
        obstawiane.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: rodzaGry=0; ramka.setImageResource(obrazki[rodzaGry]); break;
                    case 1: rodzaGry=1; ramka.setImageResource(obrazki[rodzaGry]); break;
                    case 2: rodzaGry=2; ramka.setImageResource(obrazki[rodzaGry]); break;
                    case 3: rodzaGry=3; ramka.setImageResource(obrazki[rodzaGry]); break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                polePortfel.setText(String.valueOf(portfel-i));
                poleStawka.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        ramka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stawka = suwak.getProgress();
                stawka = 0;
                portfel = portfel - suwak.getProgress();
                suwak.setMax(portfel);
                suwak.setProgress(0);
                polePortfel.setText(String.valueOf(portfel));
                poleStawka.setText(String.valueOf(stawka));
            }
        });
    }
}