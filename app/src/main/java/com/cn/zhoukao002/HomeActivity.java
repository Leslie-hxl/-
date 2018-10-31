package com.cn.zhoukao002;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import TH.ThumbnailMenu;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

public class HomeActivity extends FragmentActivity {
    private Fragment conversation = null;
    private Fragment conversationList;
    private FragmentPagerAdapter adapter;
    private List<Fragment> lists = new ArrayList<>();
    private ConversationListFragment conversationListFragment = new ConversationListFragment();
    private ViewPager vp;
    private RadioButton list;
    private RadioButton contact;
    private RadioButton setting;
    private RadioGroup radio;
    private SimpleDraweeView image;
    private ThumbnailMenu thumb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        setViewListListener();
        Fragment fragment = initConversationList();
        conversationList = fragment;

        //添加页面：
        lists.add(conversationList);
        lists.add(new FriendlistActivity());
        lists.add(new SnowAtivity());
        /**
         * 第三步：适配：
         */
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return lists.get(position);
            }

            @Override
            public int getCount() {
                return lists.size();
            }
        };
        thumb.setAdapter(adapter);

        //滑动效果
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        list.setChecked(true);
                        break;
                    case 1:
                        contact.setChecked(true);
                        break;
                    case 2:
                        contact.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.list:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.contact:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.setting:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    private Fragment initConversationList() {
        if (conversation == null) {
            conversationListFragment = (ConversationListFragment) ConversationListFragment.instantiate(this, ConversationListFragment.class.getName());

            Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationList")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false")//设置私聊会话是否聚合显示
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")//群聊
                    .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置私聊会话是否聚合显示
                    .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置私聊会是否聚合显示
                    .build();
            Log.i("ads", uri.toString());
            conversationListFragment.setUri(uri);
            return conversationListFragment;
        } else {
            return conversation;
        }
    }

    private void setViewListListener() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setVisibility(View.GONE);
                thumb.openMenu();
            }
        });
        thumb.setOnMenuCloseListener(new ThumbnailMenu.OnThumbnailMenuCloseListener() {
            @Override
            public void onMenuCloseListener() {
                image.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        contact = (RadioButton) findViewById(R.id.contact);
        setting = (RadioButton) findViewById(R.id.setting);
        radio = (RadioGroup) findViewById(R.id.radio);
        list = (RadioButton) findViewById(R.id.list);
        image = (SimpleDraweeView) findViewById(R.id.image);
        thumb = (ThumbnailMenu) findViewById(R.id.thumb);
    }
}
