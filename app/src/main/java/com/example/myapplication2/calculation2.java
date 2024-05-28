package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.math.BigInteger;

public class calculation2 extends AppCompatActivity {

    private TextView textView;
    private EditText NEdit, KEdit;
    private Button button7;

    private Switch switch2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculationcalculation);
        textView= findViewById(R.id.textView2);
        NEdit = findViewById(R.id.NEdit);
        KEdit = findViewById(R.id.KEdit);
        button7 = findViewById(R.id.button7);

        switch2 = findViewById(R.id.switch2);

        button7.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    String nText = NEdit.getText().toString();
                    String kText = KEdit.getText().toString();

                    if (!nText.isEmpty() && !kText.isEmpty()) {
                        int n = Integer.parseInt(nText);
                        int k = Integer.parseInt(kText);
                        BigInteger factorialN = calculateFactorial(n);
                        BigInteger factorialK = calculateFactorial(k);

                        BigInteger placing;
                        if (switch2.isChecked()) {

                            placing = calculatePlacingWithRepetition(n, k);
                        } else {

                            placing = calculatePlacing(n, k);
                        }

                        textView.setText("Factorial of N: " + factorialN.toString() + "\nFactorial of K: " + factorialK.toString() + "\nPlacing: " + placing.toString());
                    } else {
                        textView.setText("Please enter values for N and K.");
                    }
                }
            });


        }
    private BigInteger calculatePlacing(int n, int k){
        if (n < 0 || k < 0 || k > n) {
            return BigInteger.ZERO;
        }
        BigInteger factorialN = calculateFactorial(n);
        BigInteger factorialNK = calculateFactorial(n - k);
        BigInteger placing = factorialN.divide(factorialNK);

        return placing;
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
    public void  calculation(View v){
        Intent intent = new Intent(this,MainActivity2.class);
startActivity(intent);
    }
    private BigInteger calculatePlacingWithRepetition(int n, int k) {
        if (n < 0 || k < 0) {
            return BigInteger.ZERO;
        }

        return BigInteger.valueOf((int) Math.pow(n, k));
    }
    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}