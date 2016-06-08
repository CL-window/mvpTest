package com.example.login_mvp.model.interfaces;
/**
 * 联网监听
 * @author chenling0418
 *
 */
public interface HttpListener {
	
	void  onSuccess(String result);
	void onFailure(String error);
	
}
