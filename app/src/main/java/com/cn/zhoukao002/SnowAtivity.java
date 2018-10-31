package com.cn.zhoukao002;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class SnowAtivity extends Fragment {

    private List<String> images = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_snow_ativity, null);
        initView(view);
        images.add("https://i02picsos.sogoucdn.com/5ec2df7c84c0ba3b");
        images.add("https://i02picsos.sogoucdn.com/da786b1e8badd8cc");
        images.add("https://i03picsos.sogoucdn.com/12e6babd7e2e2743");
        images.add("https://i03picsos.sogoucdn.com/6f822f95ee606442");
        images.add("https://i01picsos.sogoucdn.com/d016eb6bba9bfdf0");
        images.add("https://i02picsos.sogoucdn.com/a42b01e047cd4836");
        titles.add("劳斯莱斯不会等下一世");
        titles.add("怪人守着红屋顶");
        titles.add("能成为密友大概总带着爱");
        titles.add("GOOCHO十五周年");
        titles.add("黄色大门&红屋顶");
        titles.add("Hello 玛丽 I AM ROSE");
        //Banner的样式:
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片的加载器：
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合：
        banner.setImages(images);
        //设置banner动画效果：
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）:
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true:
        banner.isAutoPlay(true);
        ////设置轮播时间:
        banner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）:
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setViewPagerIsScroll(true);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), "页面的点击跳转详情", Toast.LENGTH_SHORT).show();
            }
        });
        banner.start();


        return view;
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
    }
}
