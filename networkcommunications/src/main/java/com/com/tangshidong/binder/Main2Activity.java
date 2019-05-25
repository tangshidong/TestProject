package com.com.tangshidong.binder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.networkcommunications.R;

import static com.com.tangshidong.binder.IBinderService.DESCRIPITON;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myBindserver();

        // 拿到AMS的引用对象
/*
        IBinder sm = (IBinder) Reflect.on("android.os.ServiceManager").call("getService","activity").get();

        // 拿到方法编号
        int funCode = IBinder.FIRST_CALL_TRANSACTION+21;

        // 准备方法参数数据
        Parcel data = Parcel.obtain();
        // 首先要写入的数据必须是binder服务端的descriptor
        data.writeInterfaceToken("android.app.IActivityManager");
        // 接下来是方法的参数

        data.writeStrongBinder((IBinder)Reflect.on(this).field("mToken").get());

        // 用于接受返回数据
        Parcel reply = Parcel.obtain();

        // 发起RPC调用，同步调用，直到调用结束，期间一直阻塞
        try {
            sm.transact(funCode,data,reply,0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // 读取返回数据
        reply.readException();

        // 解析返回数据
        ComponentName res = ComponentName.readFromParcel(reply);

        // 回收parcle
        data.recycle();
        reply.recycle();

        Log.i("shajia","calling Activity name: "+res.getClassName());*/
    }
public  void myBindserver(){

    Intent intent = new Intent();
    intent.setClass(this,MyBinderService.class);
    bindService(intent, new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            if(service.queryLocalInterface(DESCRIPITON)==null){
                // 得到binder代理对象
                BinderServiceProxy proxy = new BinderServiceProxy(service);
                // 开始执行方法
                Log.i("shajia","message: "+proxy.getMessage());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    },BIND_AUTO_CREATE);
}

/*    public BinderServiceProxy(IBinder binder){
        if(binder.queryLocalInterface(DESCRIPITON) == null ){
            remote = binder;
            try {
                binder.linkToDeath(new IBinder.DeathRecipient() {
                    @Override
                    public void binderDied() {
                        Log.i("shajia"," binder server is deaded.");
                    }
                },0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else
            throw new RuntimeException(" this is not a BpBinder.");
    }*/
}
