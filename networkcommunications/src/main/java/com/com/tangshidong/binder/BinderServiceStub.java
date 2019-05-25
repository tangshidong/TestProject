package com.com.tangshidong.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class BinderServiceStub extends Binder implements IBinderService {

    public BinderServiceStub(){
        // 调用该方法后binder实体端的binder.queryLocalInterface()
        // 返回就不会为null。
        attachInterface(this,DESCRIPITON);
    }
    // 实现服务接口方法
    public String getMessage() {
        return " i am from Message!!!!!";
    }

    /**
     * 顾名思义，将自身转换为一个IBinder对象，
     * 因为Binder继承子Binder,Binder继承自IBinder
     */
    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code){
            case GET_MESSAGE:{
                // 客户端先发送的是服务描述，所以这里先接收服务描述并判断是否和自己一致
                data.enforceInterface(DESCRIPITON);
                // 开始执行客户端请求的服务端的方法
                String msg = getMessage();
                // 将结果打入Parcel
                reply.writeNoException();
                reply.writeString(msg);
                return true;
            }
        }
        /**
         * 必须调用父类onTransact处理其他code
         */
        return super.onTransact(code, data, reply, flags);
    }


}