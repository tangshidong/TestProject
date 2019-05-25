package com.com.tangshidong.hander;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.networkcommunications.R;

import java.util.UUID;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test();
    }

    private void test() {
        Looper_my.prepare();
        final Handler_my handler = new Handler_my() {
            @Override
            public void handleMessage(Message_my message) {
                Log.i(TAG, "main thread recv message------" + message.obj.toString());
            }
        };

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                        Message_my msg = new Message_my();
                        synchronized (UUID.class) {
                            msg.obj = UUID.randomUUID().toString();
                        }
                        Log.i(TAG, "sup thread " + Thread.currentThread().getName() + ": send message------" + msg.obj);
                        handler.sendMessage(msg);
                }
            }).start();
        }
        Looper_my.loop();
    }
}
