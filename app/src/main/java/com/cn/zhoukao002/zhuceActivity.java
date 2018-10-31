package com.cn.zhoukao002;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.clownqiang.rectcircleprogressbutton.RectCircleProgressButton;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class zhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user;
    private EditText password;
    private EditText pic;
    private Button zc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initView();
    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        pic = (EditText) findViewById(R.id.pic);
        pic.setOnClickListener(this);
        zc.setOnClickListener(this);
        zc = (Button) findViewById(R.id.zc);
        zc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zc:
                MyUser myUser = new MyUser();
                //1.获取输入框用户信息：
                String userid = user.getText().toString().trim();
                String passwords = password.getText().toString().trim();
                String pics = pic.getText().toString().trim();
                //2.添加数据;
                myUser.setUserId(userid);
                myUser.setPassword(passwords);
                myUser.setPic(pics);
                myUser.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(zhuceActivity.this, "添加数据成功,返回Objectid为：" + s, Toast.LENGTH_SHORT).show();
                            Toast.makeText(zhuceActivity.this, "注册成功！请稍后登录！", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(zhuceActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(zhuceActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
}
