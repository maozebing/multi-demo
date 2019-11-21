package cn.net.rhea.app;

import cn.net.rhea.app.websocket.MyWebsocketClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 描述 ：
 *
 * @author : MZB
 * @version : v1.00
 * @create : 2019/11/19 17:05
 * @description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    MyWebsocketClient myWebsocketClient;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        myWebsocketClient.connect();
    }
}
