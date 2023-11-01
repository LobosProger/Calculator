package com.example.studyandroidjava;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;

    private int numberA = 0;
    private int numberB = 0;
    private enum CalculationOperation {Plus, Minus, Divide, Multiply};
    private CalculationOperation calculationOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.result);
    }

    public void OnNumberButtonClicked(View view)
    {
        String textOfResult = resultText.getText().toString();
        String clickedNumber = ((Button)view).getText().toString();

        if(textOfResult.equals("0") && clickedNumber.equals("0"))
            return;

        if(!textOfResult.equals("0"))
        {
            textOfResult += clickedNumber;
        } else {
            textOfResult = clickedNumber;
        }

        resultText.setText(textOfResult);
    }

    public void OnClearButtonClicked(View view)
    {
        resultText.setText("0");
    }

    public void OnSignButtonClicked(View view)
    {
        numberA = Integer.parseInt(resultText.getText().toString());
        String sign = ((Button)view).getText().toString();

        switch (sign)
        {
            case "+": calculationOperation = CalculationOperation.Plus; break;
            case "-": calculationOperation = CalculationOperation.Minus; break;
            case "*": calculationOperation = CalculationOperation.Multiply; break;
            case "/": calculationOperation = CalculationOperation.Divide; break;
        }

        resultText.setText("0");
    }

    public void OnEqualButtonClicked(View view)
    {
        int result = 0;
        numberB = Integer.parseInt(resultText.getText().toString());

        switch (calculationOperation)
        {
            case Plus: result = numberA + numberB; break;
            case Minus: result = numberA - numberB; break;
            case Multiply: result = numberA * numberB; break;
            case Divide: result = numberA / numberB; break;
        }

        resultText.setText("" + Integer.toString(result));
    }
}