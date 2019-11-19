package cn.net.rhea.app.websocket;

import cn.net.rhea.common.model.User;
import cn.net.rhea.driver.HuaWeiDerver;
import com.sun.jndi.toolkit.url.Uri;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 描述 ：
 *
 * @author : MZB
 * @version : v1.00
 * @create : 2019/11/19 16:45
 * @description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
public class MyWebsocketClient extends WebSocketClient{

    @Resource
    private HuaWeiDerver huaWeiDerver;

    public MyWebsocketClient(URI serverUri) {
        super(serverUri);
    }


    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        List<User> list= huaWeiDerver.listUser();
        send("11111");
    }

    @Override
    public void onMessage(String s) {
        System.out.println("333333");
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }
}
