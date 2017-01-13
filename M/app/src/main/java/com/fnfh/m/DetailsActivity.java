package com.fnfh.m;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fnfh.m.bean.RiBaoDetails;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "aaaa";
    private ImageView detail_img;
    private String urlimg;
    private FloatingActionButton details_fab;

    private CollapsingToolbarLayout collapsingToolbar;
    private WebView webview;
    private int id;
    //private String url = "http://news-at.zhihu.com/api/4/news/" + id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        id = intent.getIntExtra("scid", -1);
        Log.d(TAG, "-------onResponse: " + id);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        detail_img = (ImageView) findViewById(R.id.detail_img);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        webview = (WebView) findViewById(R.id.webview);
        details_fab = (FloatingActionButton) findViewById(R.id.details_fab);
        toolbar.setNavigationIcon(R.mipmap.back);
        setSupportActionBar(toolbar);
        Okhttp();
    }

    private void Okhttp() {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://news-at.zhihu.com/api/4/news/" + id).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                Gson gson = new Gson();
                RiBaoDetails mRiBaoDetails = gson.fromJson(res, RiBaoDetails.class);

                String share_url = mRiBaoDetails.getShare_url();
                String image = mRiBaoDetails.getImage();
                String title = mRiBaoDetails.getTitle();

                DetailsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(DetailsActivity.this).load(image).into(detail_img);
                        webview.loadUrl(share_url);
                        collapsingToolbar.setTitle(title);
                    }
                });


            }
        });
    }

    //返回键
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
