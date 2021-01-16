package com.chien.myintent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //宣告元件變數
    Context context;
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //註冊元件變數
        context = this;
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        //註冊 OnClickListener
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.b1 :
                //指定開啟
//                Intent it1 = new Intent();
//                it1.setClass(context, A.class);
//                startActivity(it1);
                //不指定 隱涵式
                Intent it2 = new Intent("pageB");
                startActivity(it2);
                break;
            case R.id.b2 :
                String webside = "https://www.google.com/";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(webside));
                startActivity(web);
                break;
            case R.id.b3 :
                AlertDialog.Builder dialog= new AlertDialog.Builder(context);
                dialog.setTitle("購物車 :"); // 標題
                dialog.setMessage("確定購買?"); // 訊息
                dialog.setPositiveButton("確定", null); //按鈕 先不監聽
                dialog.show(); //顯示
                //沒有離開頁面所以不用  startActivity( );
                break;
            case R.id.b4 :
                //開電話 正規
//                Intent call = new Intent();
//                call.setAction(Intent.ACTION_DIAL);
//                call.setData(Uri.parse("tel:0921979178"));
//                startActivity(call);
                //開電話 簡易版
                Uri uri = Uri.parse("tel:0921979178");
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
                break;
                //開簡訊
//                Uri uri = Uri.parse("smsto:0921979178");
//                Intent sms = new Intent(Intent.ACTION_SENDTO, uri);
//                sms.putExtra("sms_body", "Go send");
//                startActivity(sms);
            case R.id.b5 :
                Intent mail = new Intent(Intent.ACTION_SEND);
                String[] tos = {"enelmoney@gmail.com"};
                mail.putExtra(Intent.EXTRA_EMAIL, tos);
                mail.putExtra(Intent.EXTRA_SUBJECT, "錄取通知");
                mail.putExtra(Intent.EXTRA_TEXT,
                                "\n資訊管理課"+"\n佳凌科技股份有限公司CALIN");
                mail.setType("message/rfc822");
                startActivity(mail);
                break;
        }
    }
}