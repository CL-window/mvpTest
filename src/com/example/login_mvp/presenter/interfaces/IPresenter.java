package com.example.login_mvp.presenter.interfaces;

import com.example.login_mvp.view.interfaces.IView;

/**
 * IPresenter提供了一些基础方法，其实这些方法是对应Activity或Fragment的生命周期方法
 * 有了这些生命周期方法，presenter就让Activity一心一意做它的view相关的工作。
 * 
 * @author chenling0418
 *
 * @param <V>
 */
public interface IPresenter <V  extends IView>{

    void onStop(); 
    void onResume(); 
    void onDestroy();
    void onPause();
    void onStart();
    void init(V view);
    
}
