package com.cn.zhoukao002;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import Adapter.hanlder;
import io.agora.rtc.Constants;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.video.VideoCanvas;

public class FilmActivity extends AppCompatActivity {
    static RtcEngine rtcEngine;
    String appId = "bef680ce57d448ce976a7854ea773efe";
    String room = "2046";
    private Button but;
    private FrameLayout fragment1;
    private FrameLayout fragment2;
    int values1=1;
    int values2=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        initView();
        /**
         * 初始化RtcEngine：
         */

        try {
            //创建Rtcengine对象：
            rtcEngine = RtcEngine.create(this, appId, hanlder.gethandler());

            //进入聊天室:
            rtcEngine.joinChannel(null,"hh",null,values1);

            rtcEngine.setChannelProfile(Constants.CHANNEL_PROFILE_COMMUNICATION);//设置为通信模式（默认）
            //开启视频功能：
            rtcEngine.enableVideo();

            //视频配置，设置为360P:
            rtcEngine.setVideoProfile(Constants.VIDEO_MIRROR_MODE_AUTO, false);

            setupLocalVideo(values1);
            setupRemoteVideo(values2);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //长按事件：
        but.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rtcEngine.switchCamera();
                return true;
            }
        });

        //点击事件：
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtcEngine.leaveChannel();
                finish();
            }
        });
    }

    public void setupLocalVideo(int values1) {
        SurfaceView surfaceView = RtcEngine.CreateRendererView(this);
        surfaceView.setZOrderMediaOverlay(true);
        fragment1.addView(surfaceView);
        rtcEngine.setupLocalVideo(new VideoCanvas(surfaceView,VideoCanvas.RENDER_MODE_ADAPTIVE,values1));
        Toast.makeText(this, "1添加成功", Toast.LENGTH_SHORT).show();

    }

    public void setupRemoteVideo(int values2) {
        if (fragment2.getChildCount()>=1){
            Toast.makeText(this, "视图已有控件", Toast.LENGTH_SHORT).show();
            return;
        }
        SurfaceView surfaceView = RtcEngine.CreateRendererView(this);
        fragment2.addView(surfaceView);
        rtcEngine.setupRemoteVideo(new VideoCanvas(surfaceView,VideoCanvas.RENDER_MODE_ADAPTIVE,values2));
        Toast.makeText(this, "2添加成功", Toast.LENGTH_SHORT).show();
    }
    private void initView() {
        but = (Button) findViewById(R.id.but);
        fragment1 = (FrameLayout) findViewById(R.id.fragment1);
        fragment2 = (FrameLayout) findViewById(R.id.fragment2);
    }
}
