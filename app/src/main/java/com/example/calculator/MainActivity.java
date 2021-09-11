package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int num1 = 0;int num2 = 0;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.resultTF);
    }
    public boolean getNumber() {

        EditText num1TF = (EditText) findViewById(R.id.number1TF);
        EditText num2TF = (EditText) findViewById(R.id.number2TF);


        String number1 = num1TF.getText().toString();
        String number2 = num2TF.getText().toString();

        if (number1.equals(null) || number2.equals(null)||
                number1.equals("") || number2.equals("")) {
            result.setText("");
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            num1 = Integer.parseInt(number1);
            num2 = Integer.parseInt(number2);
        }
        return true;
    }
    public void doSum(View view){
        if(getNumber()){
            int answer = num1 + num2;
            //Toast.makeText(this, Integer.toString(answer), Toast.LENGTH_SHORT).show();
            result.setText(Integer.toString(answer));
        }
    }
    public void doSubtract(View view){
        if(getNumber()){
            int answer = num1 - num2;
            result.setText(Integer.toString(answer));
        }
    }
    public void doMultiply(View view){
        if(getNumber()){
            int answer = num1 * num2;
            result.setText(Integer.toString(answer));
        }
    }
    public void doDivide(View view){
        if(getNumber()){
            if(num2!=0){
                double answer = num1 / (num2 * 1.0);
                result.setText(Double.toString(answer));
            }else{
                result.setText("");
                Toast.makeText(this, "Number cannot be divided by 0", Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void doPow(View view){
        if(getNumber()){
            double answer = Math.pow( num1, num2);
            result.setText(Double.toString(answer));
        }
    }
    public void doMod(View view){
        if(getNumber()){
            int answer = num1 % num2;
            result.setText(Integer.toString(answer));
        }
    }
}