package com.itheima.mvpdemo.model;

/**
 * MVP中的Model层
 * 1.有什么业务？
 * 登录
 */
public interface IUserLoginModel {
    /**
     * 登录业务逻辑功能
     * @param username 用户名
     * @param password 密码
     * @param listener 回调接口
     */
    void login(String username, String password, OnUserLoginListener listener);
}
