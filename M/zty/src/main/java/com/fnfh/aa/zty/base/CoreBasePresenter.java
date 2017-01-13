package com.fnfh.aa.zty.base;


import com.fnfh.aa.zty.RxManager;

/**
 * Created by hpw on 16/10/28.
 */

public abstract class CoreBasePresenter<M, T> {
    public M mModel;
    public T mView;
    public RxManager mRxManager = new RxManager();

    public void attachVM(T v, M m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void detachVM() {
        mRxManager.clear();
        mView = null;
        mModel = null;
    }

    public abstract void onStart();
}
