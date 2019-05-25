package com.com.tangshidong.binder;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class BinderServiceProxy implements IBinderService {

    /**
     * 内聚的binder引用对象
     */
    private IBinder remote;

    public BinderServiceProxy(IBinder binder){
        if(binder.queryLocalInterface(DESCRIPITON) == null )
            remote = binder;
        else
            throw new RuntimeException(" this is not a BpBinder.");
    }


    @Override
    public String getMessage() {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(DESCRIPITON);
        try {
            remote.transact(GET_MESSAGE,data,reply,0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        reply.readException();
        String msg =  reply.readString();
        data.recycle();
        data.recycle();
        return msg;
    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}