package com.fnfh.m.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.fnfh.m.DetailsActivity;
import com.fnfh.m.R;
import com.fnfh.m.bean.RiBao;
import com.fnfh.m.recyclerView.RiBaoRecyclerAdapter;
import com.fnfh.m.utils.RecyclerViewClickListener;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 作用
 * 作者
 * 日期： 2017/1/5
 */
public class RiBaoFragment extends Fragment {
    private static final String TAG = "aBD";
    private String url = "http://news-at.zhihu.com/api/4/news/latest";
    private ConvenientBanner convenientBanner;
    private RecyclerView ribao_recycleview;
    private List<RiBao.TopStoriesBean> mTopList;
    private List<RiBao.StoriesBean> mStorList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ribao, container, false);

        //找控件
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        ribao_recycleview = (RecyclerView) view.findViewById(R.id.ribao_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        ribao_recycleview.setLayoutManager(layoutManager);
        ribao_recycleview.setItemAnimator(new DefaultItemAnimator());
        ribao_recycleview.setHasFixedSize(true);

        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);

        ribao_recycleview.setNestedScrollingEnabled(false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Okhttp();

        //点击事件
        ribao_recycleview.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                /*//发布事件
                EventBus.getDefault().postSticky(
                        new MeiziEven(girlimgs.get(position).getUrl()));*/

                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                int id = mStorList.get(position).getId();
                intent.putExtra("scid",id);
                Log.d(TAG, "-------id: "+id);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
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
                RiBao mList = gson.fromJson(res, RiBao.class);
                //轮播数据
                mTopList = mList.getTop_stories();
                //carview数据
                mStorList = mList.getStories();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LunboImg();
                        RiBaoRecyclerAdapter ribaoRecycleviewAdapter = new RiBaoRecyclerAdapter(getActivity(), mStorList);
                        ribao_recycleview.setAdapter(ribaoRecycleviewAdapter);
                    }
                });
            }
        });

    }

    //无线轮播
    public void LunboImg() {
        List<String> imgs = new ArrayList<>();
        String img0 = mTopList.get(0).getImage();
        String img1 = mTopList.get(1).getImage();
        String img2 = mTopList.get(2).getImage();
        String img3 = mTopList.get(3).getImage();
        String img4 = mTopList.get(4).getImage();
        imgs.add(img0);
        imgs.add(img1);
        imgs.add(img2);
        imgs.add(img3);
        imgs.add(img4);
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, imgs) //设置需要切换的View
                .setPointViewVisible(true)    //设置指示器是否可见
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                // .setPageIndicator(new int[]{R.drawable.an1,R.drawable.an7})
                //设置指示器位置（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(2000)     //设置自动切换（同时设置了切换时间间隔）
                .setManualPageable(true);  //设置手动影响（设置了该项无法手动切换）

        //设置翻页的效果，不需要翻页效果可用不设
        //  .setPageTransformer(Transformer.DefaultTransformer);
        // convenientBanner.setManualPageable(false);//设置不能手动影响
    }

    //设置图片
    public class LocalImageHolderView implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(getActivity()).load(data).into(imageView);
            //imageView.setImageResource(data);
        }
    }

}
