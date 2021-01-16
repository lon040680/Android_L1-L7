package com.chien.uipritice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //設定相關物件變數名稱
    public TextView lable1;

    //元件初始化 ↓
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lable1 = findViewById(R.id.textView1);  //綁定元件 就是誰是誰的事情
        lable1.setText("按下按鈕 !!");
    }

    public void chengesrt(View view) {
        int price = 100;
        String name = "漢堡包";
        lable1.setText(name + " 價格 " + price + " 元");
    }

    public void appexit(View view) {
        //onBackPressed();
        finish();
    }
}