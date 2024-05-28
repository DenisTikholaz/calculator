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
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText NEdit, KEdit;
    private Button button5;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        NEdit = findViewById(R.id.NEdit);
        KEdit = findViewById(R.id.KEdit);
        button5 = findViewById(R.id.button5);
        switch1 = findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!NEdit.getText().toString().isEmpty() && !KEdit.getText().toString().isEmpty()) {
                    int n = Integer.parseInt(NEdit.getText().toString());
                    int k = Integer.parseInt(KEdit.getText().toString());

                    if (isChecked) {

                        BigInteger combinationWithRepetition = calculateCombinationWithRepetition(n, k);
                        result.setText("Combination with repetition: " + combinationWithRepetition.toString());
                    } else {

                        BigInteger combination = calculateCombination(n, k);
                        result.setText("Combination: " + combination.toString());
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nText = NEdit.getText().toString();
                String kText = KEdit.getText().toString();

                if (!nText.isEmpty() && !kText.isEmpty()) {
                    int n = Integer.parseInt(nText);
                    int k = Integer.parseInt(kText);

                    BigInteger factorialN = calculateFactorial(n);
                    BigInteger factorialK = calculateFactorial(k);
                    BigInteger combination = calculateCombination(n, k);

                    result.setText("Factorial of N: " + factorialN.toString() + "\nFactorial of K: " + factorialK.toString() + "\nCombination: " + combination.toString());
                } else {
                    result.setText("Please enter values for N and K.");
                }
            }
        });
    }

    private BigInteger calculateCombination(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            return BigInteger.ZERO;
        }

        BigInteger factorialN = calculateFactorial(n);
        BigInteger factorialK = calculateFactorial(k);
        BigInteger factorialNMinusK = calculateFactorial(n - k);

        return factorialN.divide(factorialK.multiply(factorialNMinusK));
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

    private BigInteger calculateCombinationWithRepetition(int n, int k) {
        if (n < 0 || k < 0) {
            return BigInteger.ZERO;
        }

        BigInteger numerator = calculateFactorial(n + k - 1);
        BigInteger denominator = calculateFactorial(k).multiply(calculateFactorial(n - 1));

        return numerator.divide(denominator);
    }
    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
