package com.example.lab07p01_aktywnosci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText uzytkownik, haslo;
    Button ok;
    String users[], passwords[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        haslo = findViewById(R.id.haslo);
        uzytkownik = findViewById(R.id.uzytkownik);
        ok = findViewById(R.id.ok);
        users = getResources().getStringArray(R.array.users);
        passwords = getResources().getStringArray(R.array.passwords);
        dodajSluchacze();

    }

    private void dodajSluchacze() {

        haslo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ok.setEnabled(sprawdzHaslo(charSequence.toString()));
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenja = new Intent(getApplicationContext(), MainActivity2.class);
                intenja.putExtra("user", uzytkownik.getText().toString());
                startActivity(intenja);
            }
        });
    }

    private boolean sprawdzHaslo(String s) {
        int poz = -1;
        String u = uzytkownik.getText().toString();
        for (int i=0; i<users.length; i++ )
            if (users[i].equals(u)==true) poz = i;
        if (poz>=0)
        {
            if (s.equals(passwords[poz])) return true;
        }
        return false;
    }

}