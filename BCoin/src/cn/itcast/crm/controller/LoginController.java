package cn.itcast.crm.controller;

import cn.itcast.crm.bean.UserInfo;
import cn.itcast.crm.service.LoginService;
import cn.itcast.crm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginController
 *
 * @author fenghaibang
 * @create 2018-06-29 下午3:11
 */


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/Bcoin/login")
    @ResponseBody
    public String userLgoin(UserInfo userInfo) {
        System.out.print(userInfo);
        UserInfo user = loginService.userLogin(userInfo);
        System.out.print(user);
        return "OK";
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public ModelAndView registerUserView() {
        return new ModelAndView("register");
    }
}
