package com.cn.zhoukao002;

import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;

public class MyExtensionModule extends DefaultExtensionModule{
    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        List<IPluginModule> pluginModules = super.getPluginModules(conversationType);
        //添加一个发送图片的插件
        pluginModules.add(new SamplePlugin());
        //如果需要增加的话，那么同理，在这个集合中添加需要的插件
        return pluginModules;
    }
}
