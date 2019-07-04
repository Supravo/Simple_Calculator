package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    Button modeButton;
    EditText field1;
    EditText field2;
    EditText result;
    static int mode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modeButton =findViewById(R.id.mode_change_bt);
        modeButton.setText("Mode\nAddition");
        field1 =findViewById(R.id.field1_et);
        field2 =findViewById(R.id.field2_et);
        result =findViewById(R.id.result_et);
    }

    public void mode_change(View view) {
        mode=(mode+1)%4;
        if(mode==0)
            modeButton.setText("Mode\nAddition");
        else if(mode==1)
            modeButton.setText("Mode\nSubtraction");
        else if(mode==2)
            modeButton.setText("Mode\nMultiplication");
        else if(mode==3)
            modeButton.setText("Mode\nDivision");
    }

    public void calculate(View view) {
        String x;
        double a=0,b=0;
        if(field1.getText().toString().equals(""))
        {
            Toast.makeText(this, "Field1 is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(field2.getText().toString().equals(""))
        {
            Toast.makeText(this, "Field2 is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        a = Double.parseDouble(field1.getText().toString());
        b = Double.parseDouble(field2.getText().toString());
        if(mode==0)
            x=String.valueOf(a+b);
        else if(mode==1)
            x=String.valueOf(a-b);
        else if(mode==2)
            x=String.valueOf(a*b);
        else
            x=String.valueOf(a/b);
        result.setText(x);
    }
}
