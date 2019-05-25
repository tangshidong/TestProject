package com.com.tangshidong.hander;

/**
 * Created by honjane on 2017/3/12.
 */

public final class Looper_my {


    static final ThreadLocal<Looper_my> sThreadLocal = new ThreadLocal<>();
    public MessageQueue_my mQueue;

    public Looper_my() {
        mQueue = new MessageQueue_my();
    }

    /**
     * 实例化一个属于当前线程的looper对象
     */
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper_my may be created per thread");
        }
        sThreadLocal.set(new Looper_my());
    }

    public static Looper_my myLooper() {
        return sThreadLocal.get();
    }

    /**
     * 轮询消息队列
     */
    public static void loop() {
        Looper_my me = myLooper();
        MessageQueue_my queue = me.mQueue;
        //轮询
        Message_my msg;
        for (; ; ) {
            msg = queue.next();
            //获取到发送消息的 msg.target （handler）本身，然后分发消息
            if (msg == null || msg.target == null) {
                continue;
            }

            msg.target.dispatchMessage(msg);

        }
    }
}
