package com.itheima.mvpdemo.presenter;

import android.os.Handler;

import com.itheima.mvpdemo.model.IUserLoginModel;
import com.itheima.mvpdemo.model.OnUserLoginListener;
import com.itheima.mvpdemo.model.User;
import com.itheima.mvpdemo.model.impl.UserLoginModel;
import com.itheima.mvpdemo.view.IUserLoginView;

/**
 * MVP中的Presenter层
 * 既然起到桥梁作用，那么P层肯定持有M和V层对象，成员变量
 * 既然起到桥梁作用,必须提供桥梁方法
 */
public class UserLoginPresenter implements OnUserLoginListener {
    private IUserLoginModel userLoginModel;//Model层
    private IUserLoginView userLoginView;//View层

    /**
     * 两个参数的构造方法对吗？
     * 如果是两个参数构造方法，View调用P层构造方法，view层需要传递两个参数构造方法，不符合MVP架构
     * @param userLoginView
     */
   /* public UserLoginPresenter(IUserLoginModel userLoginModel, IUserLoginView userLoginView) {
        this.userLoginModel = userLoginModel;
        this.userLoginView = userLoginView;
    }*/

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginModel = new UserLoginModel();
        this.userLoginView = userLoginView;
    }

    /**
     * 登录沟通方法
     */
    public void login(){
        //1.显示滚动条
        userLoginView.showProgressbar();
        //2.登录业务
//        String username = userLoginView.getUsername();
//        String password = userLoginView.getPassword();
        userLoginModel.login(getUsername(), getPassword(), this);
    }

    public String getUsername(){
        return userLoginView.getUsername();
    }

    public String getPassword(){
        return userLoginView.getPassword();
    }

    @Override
    public void loginSuccess(final User user) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //1.隐藏滚动条
                userLoginView.hideProgressbar();
                //2.跳转主页
                userLoginView.jump2Main(user);
            }
        });
    }

    private Handler mHandler = new Handler();

    @Override
    public void loginFailed() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //1.隐藏滚动条
                userLoginView.hideProgressbar();
                //2.提示用户登录失败
                userLoginView.showLoginError();
            }
        });

    }
}
