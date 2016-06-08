package com.example.login_mvp.view.interfaces;

import com.example.login_mvp.model.bean.UserInfo;
/**
 * 登陆的 View
 * 需要view层来实现的登录view接口，IView是所有view的基类
 * 
 * @author chenling0418
 *
 */
public interface ILoginView extends IView{

    void onShowSuccessLoginView(UserInfo userInfo);
    void onShowFailedLoginView();
    void onShowLoginCheckErrorView();
    void showLoginingView();
    void dissLoginingView();
    
}