package cn.itcast.crm.controller;

import cn.itcast.crm.bean.UserInfo;
import cn.itcast.crm.service.RegisterService;
import org.apache.commons.collections.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RegisterController
 *
 * @author fenghaibang
 * @create 2018-06-29 下午4:55
 */

/**
 *
 * 请求错误码code值解释
 * -1： 请求错误
 * 1： 请求成功
 * 2： 用户已存在
 * 3：
 *
 */

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/Bcoin/register")
    @ResponseBody
    public HashMap<String, Object> registerUser(UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        System.out.print(userInfo);
        if (userInfo.getUserPhone() == null) {
            map.put("code" , -1);
            return map;
        }
        try {
            UserInfo user = registerService.checkUserIsExistWithUserInfo(userInfo);
            if (user == null) {
                registerService.registerUserInfo(userInfo);
                map.put("code" , 1);
            }else {
                map.put("code" , 2);
            }
        } catch (Exception e) {
            map.put("code" , -1);
        }
        return map;
    }
}
