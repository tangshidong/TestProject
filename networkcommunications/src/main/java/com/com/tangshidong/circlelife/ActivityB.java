package com.com.tangshidong.circlelife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.networkcommunications.R;

public class ActivityB extends Activity {
Button bnt01;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);


        Log.e("life","ActivityB---------oncreate()");


        bnt01  = findViewById(R.id.bntb);
        bnt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityB.this,ActivityC.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("life","ActivityB---------onNewIntent()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("life","ActivityB---------onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("life","ActivityB---------onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("life","ActivityB---------onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("life","ActivityB---------onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("life","ActivityB---------onDestroy()");

    }
}
