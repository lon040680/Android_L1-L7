package com.chien.mylifecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //顯示詳細訊息的方法(目前還看不到)
        Log.i("lifecycle", "onCreate > 初始化");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifecycle", "onStart > 版面+元件 啟動");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifecycle", "onResume > 版面+元件 可見可用可操作");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifecycle", "onPause > 暫停 /版面+元件 跳開頁面");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lifecycle", "onStop > 停止 /版面+元件 不可見不可用不可操作");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("lifecycle", "onRestart > 重新 onResume /版面+元件 可見可用可操作");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle", "onDestroyt > 銷毀Activity 資源回收");
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1: //開啟瀏覽器
                String url = "https://www.google.com";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(url));
                startActivity(web);
                break;
            case R.id.button2: //跳到指定頁
                startActivity(new Intent(this, Dialog.class));
                break;
            case R.id.button3: //彈出對話框
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("xxxxxx");
                builder.setMessage("蛤 ??");
                builder.setPositiveButton("沒事 !", null);
                builder.create().show();
                break;
            case R.id.button4: //離開activity
                finish();
                break;
        }
    }
}