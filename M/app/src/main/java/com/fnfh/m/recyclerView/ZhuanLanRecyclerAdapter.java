package com.fnfh.m.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fnfh.m.R;
import com.fnfh.m.bean.ZhuanLan;

import java.util.List;

/**
 * 作用
 * 作者
 * 日期： 2016/12/16
 */
public class ZhuanLanRecyclerAdapter extends RecyclerView.Adapter<ZhuanLanRecyclerAdapter.MyViewHolder> {

    private final List<ZhuanLan.DataBean> mData;
    private Context mContext;
    private LayoutInflater inflater;

    public ZhuanLanRecyclerAdapter(Context context, List<ZhuanLan.DataBean> mData) {
        this.mContext = context;
        this.mData = mData;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
       return mData.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.zl_name.setText(mData.get(position).getName());
        holder.zl_des.setText(mData.get(position).getDescription());
        Glide.with(mContext)
                .load(mData.get(position).getThumbnail())
                .into(holder.img);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.zhuanlan_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView zl_name;
        TextView zl_des;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            zl_name = (TextView) view.findViewById(R.id.zl_name);
            zl_des = (TextView) view.findViewById(R.id.zl_des);
            img = (ImageView) view.findViewById(R.id.section_bg);
        }

    }
}