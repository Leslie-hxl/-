package com.cn.zhoukao002;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

/**
 * 融云聊天界面：
 */
public class Conversation_list extends FragmentActivity {

    private Toolbar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        initView();
//        String targetId = getIntent().getData().getQueryParameter("targetId");
        String title = getIntent().getData().getQueryParameter("title");
        if (!TextUtils.isEmpty(title)){
            bar.setTitle(title);
        }
    }

    private void initView() {
        bar = (Toolbar) findViewById(R.id.bar);
    }
}
