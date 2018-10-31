package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cn.zhoukao002.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView image;
    public TextView userid;
    public Button lj;
    public MyViewHolder(View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.sw);
        userid=itemView.findViewById(R.id.tv);
        lj=itemView.findViewById(R.id.lj);
    }
}
