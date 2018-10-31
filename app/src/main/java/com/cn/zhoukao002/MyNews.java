package com.cn.zhoukao002;

import android.support.multidex.MultiDexApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import cn.bmob.v3.Bmob;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imkit.widget.provider.RealTimeLocationMessageProvider;
import io.rong.imlib.ipc.RongExceptionHandler;
import java.util.List;
import io.rong.imkit.IExtensionModule;

/**
 * 第一步：进行初始化：
 */
public class MyNews extends MultiDexApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        //融云初始化：
        RongIM.init(this);
        RongIM.getInstance().setMessageAttachedUserInfo(true);
        RongIM.registerMessageTemplate(new RealTimeLocationMessageProvider());
        Thread.setDefaultUncaughtExceptionHandler(new RongExceptionHandler(this));//异常
        //bmob后端云初始化：
        Bmob.initialize(this,"79072538bf2f8d3353361a9b9d6bf8ff");
        Fresco.initialize(this);

        //融云自定功能注册：
        RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());

        List<IExtensionModule> moduleList= RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule=null;
        if (moduleList!=null){
            for (IExtensionModule iExtensionModule : moduleList) {
                defaultModule=iExtensionModule;
                break;
            }
            if (defaultModule!=null){
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
                RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());
            }
        }
    }
}
