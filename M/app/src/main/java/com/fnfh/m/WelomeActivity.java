package com.fnfh.m;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fnfh.aa.zty.utils.helper.RxUtil;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class WelomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welome);
        initView();
    }

    private void initView() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                //权限手机的状态权限，相机权限，读取外部储存权限
                .compose(RxPermissions.getInstance(this).ensureEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE))
                .compose(RxUtil.rxSchedulerHelper())//调度器
                .subscribe(permission -> {//开启订阅
                    if (permission.granted) {//判断给予权限
                        Intent intent = new Intent(WelomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        // startActivity(MainActivity.class);
                        finish();
                    }
                });
    }


}

