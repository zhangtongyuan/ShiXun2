package com.fnfh.m.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fnfh.m.R;
import com.fnfh.m.bean.WeiXin;
import com.fnfh.m.recyclerView.WeixinRecyclerAdapter;
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
public class WeiXinFragment extends Fragment {

    private RecyclerView wx_recyclerview;
    private String url="http://api.tianapi.com/wxnew/?key=78926886d340296c5125405447aed227&num=20&page=1%22";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weixin, container, false);
        wx_recyclerview = (RecyclerView) view.findViewById(R.id.wx_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        wx_recyclerview.setLayoutManager(layoutManager);
        wx_recyclerview.setItemAnimator(new DefaultItemAnimator());
        wx_recyclerview.setHasFixedSize(true);

        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);

        wx_recyclerview.setNestedScrollingEnabled(false);
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
                WeiXin wList = gson.fromJson(res, WeiXin.class);

                List<WeiXin.NewslistBean> newsList = wList.getNewslist();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        WeixinRecyclerAdapter adapter = new WeixinRecyclerAdapter(getActivity(), newsList);
                        wx_recyclerview.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
