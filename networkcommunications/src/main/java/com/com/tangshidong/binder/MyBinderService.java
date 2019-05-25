package com.com.tangshidong.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyBinderService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BinderServiceStub();
    }
}