package cn.net.rhea.app.api;

import cn.hutool.json.JSONObject;
import cn.net.rhea.app.mqtt.MqttPub;
import cn.net.rhea.common.model.User;
import cn.net.rhea.driver.HuaWeiDerver;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述 ：
 *
 * @author : MZB
 * @version : v1.00
 * @create : 2019/11/19 13:07
 * @description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserApi {

    @Resource
    private HuaWeiDerver huaWeiDerver;
    @Resource
    private MqttPub mqttPub;

    @GetMapping()
    public ResponseEntity listDic() throws MqttException {
        List<User> list = huaWeiDerver.listUser();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("monitoringUnit","u-wei");
        jsonObject.put("sampleUnit","rack-2");
        jsonObject.put("channel","led-3");
        jsonObject.put("parameters",new JSONObject().put("value", 0x05));
        jsonObject.put("timeout",1000);
        jsonObject.put("startTime","2018-10-01T12:00:00Z");
        jsonObject.put("phase","executing");

        mqttPub.publish("command/u-wei/rack-2/led-3",jsonObject.toString());


        return ResponseEntity.ok(list);
    }

}
