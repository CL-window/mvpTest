package com.example.login_mvp.presenter.interfaces;

import com.example.login_mvp.view.interfaces.ILoginView;


/**
 * 登陆的 Presenter，目前只有一个登陆的方法
 * 定义了登录presenter的一些方法，IPresenter是所有Presenter的基类
 * 
 * @author chenling0418
 *
 */
public interface ILoginPresenter extends IPresenter<ILoginView>{
      void login(String name,String password);
}
