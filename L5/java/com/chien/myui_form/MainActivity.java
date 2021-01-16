package com.chien.myui_form;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //註冊變數
    EditText uName, uPhone, uNum;
    TextView uPrice;
    RadioGroup uMeal, uDrink;
    RadioButton m1, m2, m3, m4, d1, d2, d3;
    CheckBox memo1, memo2, memo3;
    Context context;
    String mealString = "";
    String drinkString = "";
    String checkString = "";
    String princeString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uName = findViewById(R.id.uName);
        uPhone = findViewById(R.id.uPhone);
        uNum = findViewById(R.id.uNum);
        uPrice = findViewById(R.id.uPrice);
        uMeal = findViewById(R.id.uMeal);
        uDrink = findViewById(R.id.uDrink);
        memo1 = findViewById(R.id.memo1);
        memo2 = findViewById(R.id.memo2);
        memo3 = findViewById(R.id.memo3);
        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);
        m3 = findViewById(R.id.m3);
        m4 = findViewById(R.id.m4);

        context = this;  //Context 就是等於 MainActivity.java 然後給自己取個名字 context

        uMeal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                mealString = rb.getText().toString();
            }
        });

        uDrink.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                drinkString = rb.getText().toString();
            }
        });
    }

    //按下送出按鈕 收集 送出
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button2:
                String name = uName.getText().toString().trim();
                String phone = uPhone.getText().toString().trim();

                int[] cks = {R.id.memo1, R.id.memo2, R.id.memo3};
                checkString = "";
                for(int i : cks) {
                    CheckBox cc = findViewById(i);
                    if(cc.isChecked()){
                        checkString += cc.getText() + " ";
                    }
                }

                int num = Integer.parseInt(uNum.getText().toString());

                //送資料到第二頁起始指令
                Intent intent = new Intent();
                intent.setClass(context, Page2.class);

                //準備包裹箱送給第二頁的
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("phone", phone);
                bundle.putString("mealString", mealString);
                bundle.putString("drink", drinkString);
                bundle.putString("memo", checkString);
                bundle.putInt("num", num);

                //打包送出
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent, 9);
                break;

            case R.id.button:
                uName.setText("");
                uPhone.setText("");
                uNum.setText("");
                uPrice.setText("0元");
                break;

        }
    }

    //選擇套餐就顯示單價
    public void check(View view) {
        switch(view.getId()) {
            case R.id.m1:
                int total = 80;
                uPrice.setText(total + " 元");
                break;
            case R.id.m2:
                int total2 = 90;
                uPrice.setText(total2 + " 元");
                break;
            case R.id.m3:
                int total3 = 100;
                uPrice.setText(total3 + " 元");
                break;
            case R.id.m4:
                int total4 = 95;
                uPrice.setText(total4 + " 元");
                break;
        }
    }

    //處裡回傳結果 第二頁資料回傳給第一頁
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == requestCode){
            String price = data.getStringExtra("price");
            uPrice.setText("小計 : " + price);
        }
    }
}