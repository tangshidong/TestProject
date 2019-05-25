package com.com.tangshidong.hander;

/**
 * Created by honjane on 2017/3/12.
 */

public class Handler_my {
    private Looper_my mLooper;
    private MessageQueue_my mQueue;

    public Handler_my() {
        mLooper = Looper_my.myLooper();
        mQueue = mLooper.mQueue;
    }

    public void sendMessage(Message_my message) {
        message.target = this;
        mQueue.enqueueMessage(message);
    }

    /**
     * 子类处理消息
     *
     * @param message
     */
    public void handleMessage(Message_my message) {

    }

    /**
     * 分发消息
     *
     * @param message
     */
    public void dispatchMessage(Message_my message) {
        handleMessage(message);
    }
}
