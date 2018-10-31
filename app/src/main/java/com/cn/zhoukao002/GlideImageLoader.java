package com.cn.zhoukao002;


import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;

public class GlideImageLoader extends com.youth.banner.loader.ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //fresco加载图片：
        Uri uri=Uri.parse((String) path);
        imageView.setImageURI(uri);
    }
    public ImageView createImageView(Context context){
        SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
        return simpleDraweeView;
    }
}
