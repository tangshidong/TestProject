package com.example.networkcommunications;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
*
*网络通信篇
*
* */
public class MainActivity extends AppCompatActivity {
    private Handler mHanlde;
    private Handler subThreadHandler;

    Binder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                subThreadHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {

                        if (msg.obj instanceof String) {
                            Log.d("子线程接受到的消息",(String)msg.obj);
                        }
                    }
                };
                Looper.loop();
            }

        }).start();
        SystemClock.sleep(1000);
        Message message = new Message();
        message.obj = "这是从主线程发送的消息";
        subThreadHandler.sendMessage(message);
    }
}
