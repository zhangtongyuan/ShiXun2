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
import com.fnfh.m.bean.WeiXin;

import java.util.List;

/**
 * 作用
 * 作者
 * 日期： 2016/12/16
 */
public class WeixinRecyclerAdapter extends RecyclerView.Adapter<WeixinRecyclerAdapter.MyViewHolder> {

    private final List<WeiXin.NewslistBean> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public WeixinRecyclerAdapter(Context context, List<WeiXin.NewslistBean> mList) {
        this.mContext = context;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.wx_des.setText(mList.get(position).getTitle());
        holder.wx_from.setText(mList.get(position).getDescription());
        holder.wx_time.setText(mList.get(position).getCtime());

        Glide.with(mContext)
                .load(mList.get(position).getPicUrl())
                .into(holder.wx_img);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.weixin_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView wx_des;
        TextView wx_from;
        TextView wx_time;
        ImageView wx_img;

        public MyViewHolder(View view) {
            super(view);
            wx_img = (ImageView) view.findViewById(R.id.wx_img);
            wx_des = (TextView) view.findViewById(R.id.wx_des);
            wx_from = (TextView) view.findViewById(R.id.wx_from);
            wx_time = (TextView) view.findViewById(R.id.wx_time);

        }

    }
}