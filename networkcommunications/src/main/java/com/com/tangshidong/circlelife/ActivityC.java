package com.com.tangshidong.circlelife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.networkcommunications.R;

public class ActivityC extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Log.e("life","ActivityC---------oncreate()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("life","ActivityC---------onNewIntent()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("life","ActivityC---------onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("life","ActivityC---------onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("life","ActivityC---------onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("life","ActivityC---------onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("life","ActivityC---------onDestroy()");

    }
}
