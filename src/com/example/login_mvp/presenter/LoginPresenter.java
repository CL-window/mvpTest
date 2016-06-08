package com.example.login_mvp.presenter;

import com.example.login_mvp.model.LoginModel;
import com.example.login_mvp.model.bean.UserInfo;
import com.example.login_mvp.model.interfaces.HttpListener;
import com.example.login_mvp.presenter.interfaces.ILoginPresenter;
import com.example.login_mvp.view.interfaces.ILoginView;



/**
 * 登录的 具体的presenter，负责协调 view 和 model 
 * presenter 会有多个，负责不同功能
 * @author chenling0418
 *
 */
public class LoginPresenter implements ILoginPresenter{

	private ILoginView mLoginView;
	
	
	@Override
	public void init(ILoginView view) {
		mLoginView = view;
		mLoginView.initView();//初始化view(findById...)，此处其实是回调
	}

	@Override
	public void login(String name, String password) {
		//验证name，password的合法性,
        if(validate(name) && validate(password)){
        	// 获取单例
        	LoginModel.INSTANCE.login(name, password, new HttpListener() {
				
				@Override
				public void onSuccess(String result) {
					// 这里假设成功后返回的是用户的信息（json） 需要对result处理然后传入 onShowSuccessLoginView
					UserInfo userInfo = new UserInfo();
					//下面的代码在ui线程中执行，这就不写具体的实现了
                    mLoginView.onShowSuccessLoginView(userInfo);
                    mLoginView.dissLoginingView();
				}
				
				@Override
				public void onFailure(String error) {
					//下面的代码在ui线程中执行，这就不写具体的实现了
					mLoginView.onShowFailedLoginView();
					mLoginView.dissLoginingView();
				}
			});
        }else{
        	//假设1代表账号，密码不合法
            mLoginView.onShowLoginCheckErrorView();
        }
		
	}

	
	/**
	 * 验证数据的合法性 非空等等
	 * @param userName
	 * @return
	 */
	private boolean validate(String userName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}

	
}