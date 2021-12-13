package com.example.lab07p01_aktywnosci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String s = getIntent().getExtras().getString("user");
        TextView kto = findViewById(R.id.textView02);
        kto.setText("Zalogowany: "+s);

    }
}