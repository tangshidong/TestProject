package com.example.a31210.dong.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a31210.mykeyboardpsdview.R;

/**
 * Created by YuShuangPing on 2018/10/19.
 */
public class PsView extends LinearLayout {
    private Context context;
    private GridView gv;
    private PsAdapter adapter;
    private  int wh;

    public PsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        View view= LayoutInflater.from(context).inflate(R.layout.layout_ps_view,null);
        gv= (GridView) view.findViewById(R.id.gv_ps);
        addView(view);
    }

    public void notifyDataSetChangedPs(int psCount){
        adapter.setPsCount(psCount);
        adapter.notifyDataSetChanged();
    }
    public void setAdapter(int w){
        this.wh=w;
        adapter=new PsAdapter();
        gv.setAdapter(adapter);
    }

    class PsAdapter extends BaseAdapter {
        private int psCount=0;

        public void setPsCount(int psCount){
            this.psCount=psCount;
        }
        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if (convertView==null){
                convertView= LayoutInflater.from(context).inflate(R.layout.item_ps_view,null);
                int w=(wh-10)/6;
                convertView.setLayoutParams(new AbsListView.LayoutParams(w,158));
                holder=new ViewHolder();
                holder.iv_ps= (ImageView) convertView.findViewById(R.id.iv_ps);
                holder.view=convertView;
                convertView.setTag(holder);
            }{
                holder= (ViewHolder) convertView.getTag();
            }

            if (position==0){
                holder.view.setBackgroundResource(R.drawable.wihte_bg_lift_radius);
            }else if (position==5){
                holder.view.setBackgroundResource(R.drawable.wihte_bg_right_radius);
            }else {
                holder.view.setBackgroundResource(R.drawable.wihte_bg);
            }

            if ((position+1)<=psCount){
                holder.iv_ps.setVisibility(View.VISIBLE);
            }else {
                holder.iv_ps.setVisibility(View.INVISIBLE);
            }
            return convertView;
        }
        class ViewHolder{
            ImageView iv_ps;
            View view;
        }
    }
}
