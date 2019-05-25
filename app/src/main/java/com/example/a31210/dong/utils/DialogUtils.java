package com.example.a31210.dong.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.a31210.mykeyboardpsdview.R;

/**
 * Created by YuShuangPing on 2018/10/22.
 */
public class DialogUtils {
    public static Dialog ShowPsdDialog(Context context, View view){
        final Dialog dialog=new Dialog(context, R.style.DialogStyle2);
        dialog.setCancelable(true);
        dialog.setContentView(view);
        Window window=dialog.getWindow();
        WindowManager.LayoutParams lp=window.getAttributes();
        lp.width=ScreenUtil.getScreenWidth(context);
        window.setGravity(Gravity.BOTTOM);
        //添加动画
        window.setWindowAnimations(R.style.dialogAnim);
        window.setAttributes(lp);
        dialog.show();
        return dialog;

    }
}
