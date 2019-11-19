package cn.net.rhea.driver;

import cn.net.rhea.common.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 ：
 *
 * @author : MZB
 * @version : v1.00
 * @create : 2019/11/19 13:14
 * @description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@Service
public class HuaWeiDerver {

    public List<User> listUser() {
        List<User> list = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setName("张山");

        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");

        list.add(user);
        list.add(user2);

        return list;
    }

}
