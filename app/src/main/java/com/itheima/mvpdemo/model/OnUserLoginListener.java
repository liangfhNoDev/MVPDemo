package com.itheima.mvpdemo.model;

/**
 * 登录接口
 */
public interface OnUserLoginListener {
    /** 登录成功回调 */
    void loginSuccess(User user);

    /**登录失败回调*/
    void loginFailed();
}
