package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_zero;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_dot;

    Button btn_add;
    Button btn_sub;
    Button btn_mul;
    Button btn_div;

    Button btn_ac;
    Button btn_back;
    Button btn_mod;

    Button btn_eq;
    Button btn_br;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_zero = findViewById(R.id.button_zero);
        btn_1 = findViewById(R.id.button_1);
        btn_2 = findViewById(R.id.button_2);
        btn_3 = findViewById(R.id.button_3);
        btn_4 = findViewById(R.id.button_4);
        btn_5 = findViewById(R.id.button_5);
        btn_6 = findViewById(R.id.button_6);
        btn_7 = findViewById(R.id.button_7);
        btn_8 = findViewById(R.id.button_8);
        btn_9 = findViewById(R.id.button_9);

        btn_dot = findViewById(R.id.button_dot);

        btn_add = findViewById(R.id.button_plus);
        btn_sub = findViewById(R.id.button_sub);
        btn_mul = findViewById(R.id.button_mul);
        btn_div = findViewById(R.id.button_div);


        btn_ac = findViewById(R.id.button_AC);
        btn_back = findViewById(R.id.button_back);
        btn_mod= findViewById(R.id.button_mod);
        btn_eq= findViewById(R.id.button_eq);
        btn_br= findViewById(R.id.button_br);

        textView = findViewById(R.id.textViewIn);


        btn_zero.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_mod.setOnClickListener(this);
        btn_eq.setOnClickListener(this);
        btn_br.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_zero:
                textView.append("0");
                break;
            case R.id.button_1:
                textView.append("1");
                break;
            case R.id.button_2:
                textView.append("2");
                break;
            case R.id.button_3:
                textView.append("3");
                break;
            case R.id.button_4:
                textView.append("4");
                break;
            case R.id.button_5:
                textView.append("5");
                break;
            case R.id.button_6:
                textView.append("6");
                break;
            case R.id.button_7:
                textView.append("7");
                break;
            case R.id.button_8:
                textView.append("8");
                break;
            case R.id.button_9:
                textView.append("9");
                break;

            case R.id.button_AC:
                textView.setText("0");
                break;
            case R.id.button_dot:
                textView.append(".");
                break;

            case R.id.button_plus:
                textView.append("+");
                break;

            case R.id.button_sub:
                textView.append("-");
                break;

            case R.id.button_mul:
                textView.append("*");
                break;

            case R.id.button_div:
                textView.append("/");
                break;

            case R.id.button_back:
                textView.setText(textView.getText().toString().substring(0,textView.getText().toString().length() - 1));
                break;

            case R.id.button_eq:

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();

                finalResult = rhino.evaluateString(scriptable,textView.getText().toString(),"Javsscript",1,null).toString();

                if(finalResult.substring(finalResult.length()-2).equals(".0"))
                {
                    finalResult = finalResult.substring(0,finalResult.length()-2);
                }

                textView.setText(finalResult);
                break;

        }

    }
}
