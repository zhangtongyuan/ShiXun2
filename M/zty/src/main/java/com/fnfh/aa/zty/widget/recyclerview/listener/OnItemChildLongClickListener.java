package com.fnfh.aa.zty.widget.recyclerview.listener;

import android.view.View;

import com.fnfh.aa.zty.widget.recyclerview.BaseQuickAdapter;


/**
 * A convenience class to extend when you only want to OnItemChildLongClickListener for a subset
 * of all the SimpleClickListener. This implements all methods in the
 * {@link SimpleClickListener}
 **/
public abstract class OnItemChildLongClickListener extends SimpleClickListener {


    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
        SimpleOnItemChildLongClick(adapter,view,position);
    }
    public abstract void SimpleOnItemChildLongClick(BaseQuickAdapter adapter, View view, int position);
}
