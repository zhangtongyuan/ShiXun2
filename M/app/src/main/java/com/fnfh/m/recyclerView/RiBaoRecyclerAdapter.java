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
import com.fnfh.m.bean.RiBao;

import java.util.List;

/**
 * 作用
 * 作者
 * 日期： 2016/12/16
 */
public class RiBaoRecyclerAdapter extends RecyclerView.Adapter<RiBaoRecyclerAdapter.MyViewHolder> {

    private final List<RiBao.StoriesBean> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public RiBaoRecyclerAdapter(Context context, List<RiBao.StoriesBean> mList) {
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

        holder.tv1.setText(mList.get(position).getTitle());
        Glide.with(mContext)
                .load(mList.get(position).getImages().get(0))
                .into(holder.img);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.ribao_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;
        TextView tv2;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv1 = (TextView) view.findViewById(R.id.tv1);
            img = (ImageView) view.findViewById(R.id.img);
        }

    }
}