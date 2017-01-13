package com.fnfh.m.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fnfh.m.R;
import com.fnfh.m.bean.ZhuanLan;
import com.fnfh.m.recyclerView.ZhuanLanRecyclerAdapter;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * 作用
 * 作者
 * 日期： 2017/1/5
 */
public class ZhuanLanFragment extends Fragment {
    private static final String TAG = "Aaaaaa";
    private String url = "http://news-at.zhihu.com/api/4/sections";
    private RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhuanlan, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.zl_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Okhttp();
    }

    private void Okhttp() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                Gson gson = new Gson();
                ZhuanLan zhuanLan = gson.fromJson(res, ZhuanLan.class);

                List<ZhuanLan.DataBean> mData = zhuanLan.getData();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ZhuanLanRecyclerAdapter adapter = new ZhuanLanRecyclerAdapter(getActivity(), mData);
                        recyclerview.setAdapter(adapter);
                    }
                });
            }
        });

    }
}
