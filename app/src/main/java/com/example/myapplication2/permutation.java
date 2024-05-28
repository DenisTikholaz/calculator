package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.math.BigInteger;

public class permutation extends AppCompatActivity {

    private TextView textView7, textView19;
    private EditText NEdit;
    private Button button9;
    private EditText editText2;
    private Switch Switch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permutation);
        NEdit = findViewById(R.id.NEdit);
        textView7 = findViewById(R.id.textView7);
        button9 = findViewById(R.id.button9);
        Switch3 = findViewById(R.id.switch3);
        editText2 = findViewById(R.id.editText2);
        textView19 = findViewById(R.id.textView19);

        textView19.setVisibility(View.GONE);
        editText2.setVisibility(View.GONE);

        Switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView19.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                } else {
                    textView19.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nText = NEdit.getText().toString();

                if (!nText.isEmpty()) {
                    int n = Integer.parseInt(nText);


                    BigInteger factorialN = calculateFactorial(n);

                    textView7.setText("Factorial of N: " + factorialN.toString());
                } else {
                    textView7.setText("Please enter a value for N.");
                }
            }
        });
    }

    private BigInteger calculateFactorial(int number) {
        if (number < 0) {
            return BigInteger.ZERO;
        }

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}