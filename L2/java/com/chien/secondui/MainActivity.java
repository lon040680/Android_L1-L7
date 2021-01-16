package com.chien.secondui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //指定元件名稱
    EditText keyin_name;
    TextView textView_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //註冊元件 這裡就如同 Swing 設定裡 JButton btn_1 = new JButton; 的行為一樣
        keyin_name = findViewById(R.id.keyin_name);
        textView_1 = findViewById(R.id.textView_1);
    }

    public void onClick(View view) {
        //textView_1.setText(keyin_name.getText());
        String name = keyin_name.getText().toString();
        textView_1.setText(name);

        //顯示跳窗
        Toast toast = Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        //Snackbar.make(view, name, Snackbar.LENGTH_LONG).show();

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Page2.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}