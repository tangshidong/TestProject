package com.com.tangshidong.binder;

import android.os.IBinder;
import android.os.IInterface;

public interface IBinderService extends IInterface {
    String getMessage();
    /**
     * 服务的描述，客户端在使用parcel跨进程传输数据的时候
     * 必须首先写入服务的描述，即该数据是发给哪个binder的。
     * 将来服务端收到数据后会检查这个服务描述是否和自己的一致，不一致就不做处理了
     */
    String DESCRIPITON = "MyBinderService";
    // 定义方法编号
    int GET_MESSAGE = IBinder.FIRST_CALL_TRANSACTION+0;
}