package cn.net.rhea.app;

import cn.net.rhea.app.mqtt.MqttSub;
import cn.net.rhea.app.websocket.MyWebsocketClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 描述 ：
 *
 * @author : MZB
 * @version : v1.00
 * @create : 2019/11/19 17:14
 * @description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@Configuration
public class BeanConfig {

    @Value("${websocket.url}")
    private String url;

    @Bean
    MyWebsocketClient myWebsocketClient() throws URISyntaxException {
        return new MyWebsocketClient(new URI(url));
    }

}
