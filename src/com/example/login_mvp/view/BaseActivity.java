package com.example.login_mvp.view;

import java.util.HashSet;
import java.util.Set;

import com.example.login_mvp.presenter.interfaces.IPresenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * BaseActivity 所有Activity的基类
 * 
 * @author chenling0418
 * 
 */
public abstract class BaseActivity extends FragmentActivity {

	private Set<IPresenter> mAllPresenters = new HashSet<IPresenter>();

	/**
	 * * 获取layout的id，具体由子类实现
	 * 
	 * @return
	 */
	protected abstract int getLayoutResId();

	/**
	 * 需要子类来实现，获取子类的IPresenter，一个activity有可能有多个IPresenter
	 */
	protected abstract IPresenter[] getPresenters();

	// 初始化presenters，
	protected abstract void onInitPresenters();

	/**
	 * * 从intent中解析数据，具体子类来实现
	 * 
	 * @param argIntent
	 */
	protected void parseArgumentsFromIntent(Intent argIntent) {
	}

	/**
	 * 此处是把所有的presenter 添加到  mAllPresenters 集合
	 * 
	 * 这里用到了设计模式里的 观察者模式，对象之间的一对多的依赖，这样一来，当一个对象改变时，
	 * 它的所有的依赖者都会收到通知并自动更新
	 * 
	 */
	private void addPresenters() {

		IPresenter[] presenters = getPresenters();
		if (presenters != null) {
			for (int i = 0; i < presenters.length; i++) {
				mAllPresenters.add(presenters[i]);
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResId());
		if (getIntent() != null) {
			parseArgumentsFromIntent(getIntent());
		}
		addPresenters();

		onInitPresenters();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 依次调用IPresenter的onResume方法
		for (IPresenter presenter : mAllPresenters) {
			if (presenter != null) {
				presenter.onResume();
			}
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 依次调用IPresenter的onResume方法
		for (IPresenter presenter : mAllPresenters) {
			if (presenter != null) {
				presenter.onDestroy();
			}
		}
	}

	// ...其他生命周期方法也是类似，调用IPresenter中相应的生命周期方法...

}
