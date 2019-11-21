package cn.net.rhea.app.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述 ：
 *
 * @author : MZB
 * @version : v1.00
 * @create : 2019/11/21 10:36
 * @description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@Component
public class MqttPub {

    @Value("${mqtt.host}")
    private String host;

    private static final String clientid = "server11";
    private static final int qos = 1;

    private MqttClient client;

    /**
     *  用来连接服务器
     */
    private void connect() {
        try {
            client = new MqttClient(host, clientid, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            //options.setUserName(userName);
            //options.setPassword(passWord.toCharArray());
            // 设置超时时间
            options.setConnectionTimeout(10);
            // 设置会话心跳时间
            options.setKeepAliveInterval(20);
            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publish(String topic,String content) throws MqttPersistenceException, MqttException {
        connect();
        // 创建消息
        MqttMessage message = new MqttMessage(content.getBytes());
        // 设置消息的服务质量
        message.setQos(qos);
        // 发布消息
        MqttDeliveryToken token = client.getTopic(topic).publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! " + token.isComplete());
        client.disconnect();
        client.close();
    }

}
