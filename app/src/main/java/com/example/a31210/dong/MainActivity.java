package com.example.a31210.dong;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a31210.mykeyboardpsdview.R;
import com.example.a31210.dong.utils.DialogUtils;
import com.example.a31210.dong.view.KeyBoardView;
import com.example.a31210.dong.view.PsView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_input;
    private Dialog dialog;
    String ps="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_input= (Button) findViewById(R.id.btn_input);
        btn_input.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_input:

                View view=getLayoutInflater().inflate(R.layout.layout_psd_keyboard,null);
                final PsView psView= (PsView) view.findViewById(R.id.ps_view);
                KeyBoardView keyBoardView= (KeyBoardView) view.findViewById(R.id.key_board);
               ImageView iv_dismiss= (ImageView) view.findViewById(R.id.diess_dialog);
                //设置键盘上的数字
                keyBoardView.setKeyBoardData(new String[]{"1","2","3","4","5","6","7","8","9","","0","backspace"});
                //注册监听视图树的观察者(observer),当一个视图树的布局发生改变时，可以被ViewTreeObserver监听到
                ViewTreeObserver observer=psView.getViewTreeObserver();
                observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Toast.makeText(MainActivity.this,"dfdasjfllasl",Toast.LENGTH_LONG).show();
                        //将OnGlobalLayoutListener注销掉 ,防止多次触发
                        psView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        psView.setAdapter(psView.getWidth());
                    }
                });
                dialog= DialogUtils.ShowPsdDialog(this,view);
                iv_dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        ps="";
                    }
                });
                keyBoardView.setOnKeyBoardItemClickListener(new KeyBoardView.OnKeyBoardItemClickListener() {
                    @Override
                    public void onNumItemClick(View view, String num) {
                        if(ps.length()<7){
                            ps+=num;
                        }

                    }

                    @Override
                    public void onBackSpaceClick(View view) {
                        if (ps.length()>=1){
                            ps=ps.substring(0,ps.length()-1);
                        }
                    }

                    @Override
                    public void onTotalNum(View view) {
                        if (ps.length()==6){
                            Toast.makeText(MainActivity.this,"输入的密码为："+ps,Toast.LENGTH_LONG).show();
                        }
                        psView.notifyDataSetChangedPs(ps.length());

                    }
                });
                break;
        }
    }
}
