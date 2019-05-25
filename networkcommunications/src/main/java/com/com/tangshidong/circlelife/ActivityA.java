package com.com.tangshidong.circlelife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.networkcommunications.R;

public class ActivityA  extends Activity {
    Button  bnt01;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.e("life","ActivityA---------oncreate()");
        bnt01  = findViewById(R.id.bnta);
        bnt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityA.this,ActivityB.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("life","ActivityA---------onNewIntent()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("life","ActivityA---------onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("life","ActivityA---------onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("life","ActivityA---------onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("life","ActivityA---------onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("life","ActivityA---------onDestroy()");

    }
}
