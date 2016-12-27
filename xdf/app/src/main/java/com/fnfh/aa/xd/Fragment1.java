package com.fnfh.aa.xd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * resource 布局 root 容器 attached to root 没有挂载的父控件
         */
        View view = inflater.inflate(R.layout.fragment1, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tv1);
        tv.setText("1111111111111");
        return view;
    }

}
