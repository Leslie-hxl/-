package com.cn.zhoukao002;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Adapter.MyRecyclerAdapter;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SQLQueryListener;

/**
 * 进行登录注册：
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user;
    private EditText password;
    private Button dl;
    private Button zc;
    String sql=" select * from MyUser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        dl = (Button) findViewById(R.id.dl);
        zc = (Button) findViewById(R.id.zc);
        dl.setOnClickListener(this);
        zc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dl:
                //1.获取输入框用户信息：
                final String userid = user.getText().toString().trim();
                final String passwords = password.getText().toString().trim();

                if(userid.equals("")||passwords.equals("")){
                    Toast.makeText(this, "帐号或密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                new BmobQuery<MyUser>().doSQLQuery(sql, new SQLQueryListener<MyUser>() {
                    @Override
                    public void done(BmobQueryResult<MyUser> bmobQueryResult, BmobException e) {
                        if (e == null) {
                            List<MyUser> results = bmobQueryResult.getResults();
                            for (int i = 0; i < results.size(); i++) {
                                String userId1 = results.get(i).getUserId();
                                String password1 = results.get(i).getPassword();
                                if (userId1.equals(userid) && password1.equals(passwords)) {
                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    break;
                                }else{
                                    Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }, MainActivity.this);
                break;
            case R.id.zc:
                startActivity(new Intent(this,zhuceActivity.class));
                break;
        }
    }
}
