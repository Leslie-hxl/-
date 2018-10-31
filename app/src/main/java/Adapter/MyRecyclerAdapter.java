package Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.cn.zhoukao002.FilmActivity;
import com.cn.zhoukao002.MyFriend;
import com.cn.zhoukao002.MyUser;
import com.cn.zhoukao002.R;
import java.util.ArrayList;
import java.util.List;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcEngine;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> implements RongIM.UserInfoProvider {
    private Context context;
    private List<MyUser> list;
    List<MyFriend> friends=new ArrayList<>();
    String Toast1 = "9IxkvpfDue/ZuVimVvH1XUlcgGwNJ3Im62TIf7uU4iEtLG2iZMVY1JnyXEr3z/7MPEsmCiBwRwpLBd4bd+mtyQ==";
    String Toast2 = "nnPMRXWMO0It995Vlwgdiu2hdpaDa4DAKe5NQwe4+K7IAUXUmLXJCsVlkfh9slBO6riZbJDjpP5XqgxUKtdNYQ==";

    public MyRecyclerAdapter(Context context, List<MyUser> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.items,null);
        MyViewHolder holders=new MyViewHolder(view);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.userid.setText(list.get(position).getPassword());
        holder.image.setImageURI(list.get(position).getPic());

        intoprivider();
        holder.userid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).getUserId().equals("1")){
                    Toast.makeText(context, "Hocc请求进行语音聊天", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, FilmActivity.class);
                    context.startActivity(intent);
                }else if (list.get(position).getUserId().equals("2")){
                    Toast.makeText(context, "Joey请求进行语音聊天", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, FilmActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        holder.lj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).getUserId().equals("1")){
                    connectRongServer(Toast1);
                }else if (list.get(position).getUserId().equals("2")){
                    connectRongServer(Toast2);
                }
            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position).getPassword(), Toast.LENGTH_SHORT).show();
                if (list.get(position).getUserId().equals("1")){
                    RongIM.getInstance().startPrivateChat(context,"2","私人聊天");
                    RongIM.getInstance().enableNewComingMessageIcon(true);//显示新消息提醒
                    RongIM.getInstance().enableUnreadMessageIcon(true);//显示未读消息数目
                }else if (list.get(position).getUserId().equals("2")){
                    RongIM.getInstance().startPrivateChat(context,"1","私人聊天");
                    RongIM.getInstance().enableNewComingMessageIcon(true);//显示新消息提醒
                    RongIM.getInstance().enableUnreadMessageIcon(true);//显示未读消息数目
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * IMKit SDK调用第四步 :(建立与服务器的连接)
     */
    private void connectRongServer(String Token) {
        RongIM.connect(Token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                //Connect Token 失效的状态处理，需要重新获取 Token
                Log.i("MainActivity","失效，请重新获取Token！");
            }

            /**
             * 连接融云成功
             * userid当前 token 对应的用户 id
             */
            @Override
            public void onSuccess(String userId) {
                if (userId.equals("1")) {
                    Toast.makeText(context, "用户Hocc连接服务端成功！", Toast.LENGTH_SHORT).show();
                } else if(userId.equals("2")){
                    Toast.makeText(context, "用户Joey连接服务端成功！", Toast.LENGTH_SHORT).show();
                }
                Log.i("MainActivity", "——onSuccess——" + userId);
            }

            /**
             * 连接融云失败
             * @param errorCode 错误码，可到官网 查看错误码对应的注释
             */
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.i("MainActivity", "——onError——" + errorCode.getValue());
            }
        });
    }

    //添加用户信息：
    private void intoprivider() {
        friends.add(new MyFriend("1", "Hocc", "https://img02.sogoucdn.com/app/a/100520093/f263cc16af3c7d3d-a4b88ae4ecaeebad-395e39876a1871bb7ff4ca4aaf8e73a5.jpg"));
        friends.add(new MyFriend("2", "Joey", "https://img03.sogoucdn.com/app/a/100520093/d7036c9a17f5fda2-e89831d7f22ae719-b626654723b78c9ee99d1aa7408950a9.jpg"));
        RongIM.setUserInfoProvider(this, true);
    }

    @Override
    public UserInfo getUserInfo(String s) {
        for (MyFriend friend : friends) {
            if (friend.getUserId().equals(s)){
                return new UserInfo(friend.getUserId(),friend.getPassword(), Uri.parse(friend.getPic()));
            }
        }
        Log.i("MainActivity","userid is:"+s);
        return null;
    }

}
