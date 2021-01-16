package com.chien.myui_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7;
    Context context;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        context = this;
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);

        //接收資源包裹並放入各自欄位
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String meal = bundle.getString("mealString");
        int n = bundle.getInt("num");

        t1.setText("姓名 : "+ bundle.getString("name"));
        t2.setText("電話 : "+ bundle.getString("phone"));
        t3.setText("便當 : " + meal);
        t4.setText("飲料 : " + bundle.getString("drink"));
        t5.setText("備註 : " + bundle.getString("memo"));
        t6.setText("數量 : "+ n);

        if(meal.equals("排骨")) {
            t7.setText("小計 : " + (80 * n));
            price = 80 * n;
        }
        else if(meal.equals("魚排")) {
            t7.setText("小計 : " + (90 * n));
            price = 90 * n;
        }
        else if(meal.equals("雞腿")) {
            t7.setText("小計 : " + (100 * n));
            price = 100 * n;
        }
        else if(meal.equals("咖哩")) {
            t7.setText("小計 : " + (95 * n));
            price = 95 * n;
        }


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit:
                Intent it2 = new Intent();
                it2.putExtra("price", price + "");
                setResult(9, it2);
                finish();
                break;

            case R.id.clear:
                finish();
        }
    }
}