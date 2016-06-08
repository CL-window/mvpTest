package com.example.login_mvp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText  mUserName, mPassword;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView() {

		// findViewById.....
		
	}

	/**
	 * 登陆按钮，需要验证输入的数据合法性
	 * @param view
	 */
	public void loginCheck(View view){
		 String userName = mUserName.getText().toString();
         String password = mPassword.getText().toString();
         //验证用户输入的密码是否合法
         if(!validate(userName) || !validate(password)){
        	 //告诉用户输入的用户名或密码不合法
         }  else{
             //开始登陆
             login(userName,password);
         }
	}
	
	/**
	 * 访问网络进行登陆,分登陆成功和失败，显示不同的界面
	 * @param userName
	 * @param password
	 */
	private void login(String userName, String password) {
		
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
	

}
