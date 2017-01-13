package com.fnfh.aa.zty.widget.recyclerview.listener;

import android.view.View;

import com.fnfh.aa.zty.widget.recyclerview.BaseQuickAdapter;


public abstract class OnItemLongClickListener extends SimpleClickListener {




    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
        SimpleOnItemLongClick( adapter,  view,  position);
    }

    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }


    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
    }
    public abstract void SimpleOnItemLongClick(BaseQuickAdapter adapter, View view, int position);
}
