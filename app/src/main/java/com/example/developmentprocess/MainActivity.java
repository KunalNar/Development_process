package com.example.developmentprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btndurring =(Button)findViewById(R.id.btn_Before_Development);

        btndurring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, During_development.class);
                startActivity(in);
            }
        });

        Button btn =(Button)findViewById(R.id.btn_Before_Development);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Page2.class);
                startActivity(intent2);
            }
        });





    }


    }

