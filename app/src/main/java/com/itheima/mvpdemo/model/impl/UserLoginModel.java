package com.itheima.mvpdemo.model.impl;

import android.os.SystemClock;

import com.itheima.mvpdemo.model.IUserLoginModel;
import com.itheima.mvpdemo.model.OnUserLoginListener;
import com.itheima.mvpdemo.model.User;

/**
 *
 */
public class UserLoginModel implements IUserLoginModel {
    @Override
    public void login(final String username, final String password, final OnUserLoginListener listener) {
        //访问网络，登录，模拟
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                //登录：判断用户名和密码
                if("heima29".equals(username) && "123456".equals(password)){//登录成功
                    User user = new User(username, password);
                    listener.loginSuccess(user);
                }else{//失败
                    listener.loginFailed();
                }
            }
        }).start();
    }
}
