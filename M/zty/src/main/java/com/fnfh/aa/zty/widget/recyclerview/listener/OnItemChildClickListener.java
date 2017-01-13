package com.fnfh.aa.zty.widget.recyclerview.listener;

import android.view.View;

import com.fnfh.aa.zty.widget.recyclerview.BaseQuickAdapter;


/**
 * A convenience class to extend when you only want to OnItemChildClickListener for a subset
 * of all the SimpleClickListener. This implements all methods in the
 * {@link SimpleClickListener}
 **/

public abstract class OnItemChildClickListener extends SimpleClickListener {

    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }


    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        SimpleOnItemChildClick(adapter, view, position);
    }


    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    public  abstract void SimpleOnItemChildClick(BaseQuickAdapter adapter, View view, int position);

}
