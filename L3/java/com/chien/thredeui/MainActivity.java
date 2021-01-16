package com.chien.thredeui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //指定元件名稱(先告變數)
    EditText TextFields1, TextFields2;
    RadioGroup Gender;
    CheckBox cb1, cb2, cb3;
    Button button;
    TextView viewall;
    String result;
    String name;
    String email;
    String sex = "男";
    String cbString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextFields1 = findViewById(R.id.TextFields1);
        TextFields2 = findViewById(R.id.TextFields2);
        Gender = findViewById(R.id.Gender);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);  //cb這組可以不做
        button = findViewById(R.id.button);
        viewall = findViewById(R.id.viewall);

        //按鍵監聽
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收集 TextFields
                name = TextFields1.getText().toString();
                email = TextFields2.getText().toString();

//                //收集 RadioGroup
//                Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(RadioGroup group, int checkedId) {
//                        RadioButton rb = findViewById(checkedId);
//                        sex = rb.getText().toString();
//                    }
//                });

                //收集 CheckBox
                int[] cbarrays = {R.id.cb1, R.id.cb2, R.id.cb3};
                cbString ="";
                for(int i : cbarrays) {
                    CheckBox cbc = findViewById(i);
                    if(cbc.isChecked()){
                        cbString += cbc.getText().toString() + ",";
                    }
                }

                //總收集
                result = "姓名 : "+ name + "\nEmial: " + email + "\n性別 :" + sex + "\n學歷 : " + cbString;
                viewall.setText(result);
            }
        });
    }

    public void gender_1(View view) {
        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                sex = rb.getText().toString();
            }
        });
    }

    public void gender_2(View view) {
        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                sex = rb.getText().toString();
            }
        });
    }

    public void gender_3(View view) {
        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                sex = rb.getText().toString();
            }
        });
    }
}