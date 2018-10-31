package com.cn.zhoukao002;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Adapter.MyRecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

public class FriendlistActivity extends Fragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private List<MyUser> list;
    String sql = " select * from MyUser";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_friendlist, null);

        new BmobQuery<MyUser>().doSQLQuery(sql, new SQLQueryListener<MyUser>() {
            @Override
            public void done(BmobQueryResult<MyUser> bmobQueryResult, BmobException e) {
                if (e == null) {
                    list = bmobQueryResult.getResults();
                    LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                    rv.setLayoutManager(manager);
                    MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), list);
                    rv.setAdapter(adapter);
                }
            }
        }, FriendlistActivity.this);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
