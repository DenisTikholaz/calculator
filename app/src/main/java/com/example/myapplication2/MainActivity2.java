package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }
        public void startNewActivity (View v){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        public void startNewActivity1 (View v){
            Intent intent1 = new Intent(this, calculation2.class);
            startActivity(intent1);
        }
        public void startNewActivity2 (View v){

            Intent intent2 = new Intent(this, permutation.class);
            startActivity(intent2);
        }
    }
