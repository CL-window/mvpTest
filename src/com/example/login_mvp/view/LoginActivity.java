package com.example.login_mvp.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.login_mvp.R;
import com.example.login_mvp.model.bean.UserInfo;
import com.example.login_mvp.presenter.LoginPresenter;
import com.example.login_mvp.presenter.interfaces.IPresenter;
import com.example.login_mvp.view.interfaces.ILoginView;

/**
 * view 只专心负责各种 显示
 * 
 * @author chenling0418
 *
 */
public class LoginActivity extends BaseActivity implements ILoginView{

	
	private LoginPresenter mLoginPresenter = new LoginPresenter();
	private EditText  mUserName, mPassword;
	private Button mLogin;
   
	@Override
	public void initView() {
		//  ...初始化view的代码... findViewById...
		mLogin = (Button)findViewById(R.id.login);
        mLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mLoginPresenter.login(mUserName.getText().toString(), mPassword.getText().toString());
			}
		});
	}

	@Override
	public void onShowSuccessLoginView(UserInfo userInfo) {
		// ....显示登录成功界面....
		
	}

	@Override
	public void onShowFailedLoginView() {
		// ...显示登录失败界面...
		
	}

	@Override
	public void showLoginingView() {
		// ...显示登录进度条对话框...
		
	}

	@Override
	public void dissLoginingView() {
		//  ...消失登录进度条对话框...
		
	}

	@Override
	protected int getLayoutResId() {
		return R.layout.activity_login;
	}

	@Override
	protected IPresenter[] getPresenters() {
		return new IPresenter[]{ mLoginPresenter};
	}

	@Override
	protected void onInitPresenters() {
		mLoginPresenter.init(this);
		
	}

	@Override
	public void onShowLoginCheckErrorView() {
		//  ...显示填入信息错误界面...
		
	}

}
