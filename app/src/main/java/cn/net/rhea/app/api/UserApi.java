package cn.net.rhea.app.api;

import cn.net.rhea.common.model.User;
import cn.net.rhea.driver.HuaWeiDerver;
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

    @GetMapping()
    public ResponseEntity listDic() {
        List<User> list = huaWeiDerver.listUser();


        return ResponseEntity.ok(list);
    }

}
