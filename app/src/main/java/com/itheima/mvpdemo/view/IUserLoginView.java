package com.itheima.mvpdemo.view;

import com.itheima.mvpdemo.model.User;

/**
 * MVP中的View层
 * 如何写View层代码？
 * 看页面，哪些是View
 * 1.有什么操作：获取用户名、获取密码
 * 2.有什么用户体验：显示滚动条、隐藏滚动条
 * 3.有什么结果：登录成功跳转主页、登录失败提示用户
 */
public interface IUserLoginView {
    /**获取用户名*/
    String getUsername();
    /**获取密码*/
    String getPassword();

    /**显示滚动条*/
    void showProgressbar();
    /**隐藏滚动条*/
    void hideProgressbar();

    /**登录成功跳转主页*/
    void jump2Main(User user);
    /**登录失败提示用户*/
    void showLoginError();
}
