package com.example.login_mvp.model;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import android.util.Log;

import com.example.login_mvp.model.interfaces.HttpListener;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * 联网获取数据，使用xUtil工具
 * enum  实现单例
 * @author chenling0418
 *
 */
public enum LoginModel {

	/** enum 实现单例
     * 定义一个枚举的元素，它就代表了LoginModel的一个实例。
     */
	INSTANCE;
	
	/** 登陆
	 * @param name 姓名
	 * @param password 密码
	 * @param loginListener 登陆结果的回调
	 */
	public void login(String name,String password,final HttpListener loginListener){
		
		// 使用xUtil ，HttpUtils也应该只有一个实例，这里是模拟
		HttpUtils httpUtils = new HttpUtils();
		
		RequestParams requestParams = new RequestParams();
		// 建议使用 JSON交互   JsonObject
		try {
			requestParams.setBodyEntity(new StringEntity("your params"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Log.i("slack", "error:"+e.toString());
		}

		
		// send(HttpMethod method, String url, RequestParams params, RequestCallBack<Object> callBack)
		httpUtils.send(HttpMethod.POST, "your webservice host", requestParams, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String error) {
				// TODO Auto-generated method stub
				if(loginListener != null){
					loginListener.onFailure(error);
				}
			}

			@Override
			public void onSuccess(ResponseInfo<String> result) {
				// TODO Auto-generated method stub
				if(loginListener != null){
					loginListener.onSuccess(result.result);
				}
			}
		});
		
		
	}

}
