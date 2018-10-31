package com.cn.zhoukao002;

import android.graphics.Paint;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * 创建用户信息表
 */
public class MyUser extends BmobObject implements Serializable{
    private String userId;
    private String password;
    private String Pic;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }
}
