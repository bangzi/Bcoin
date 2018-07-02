package cn.itcast.crm.service.impl;

import cn.itcast.crm.bean.UserInfo;
import cn.itcast.crm.dao.LoginDao;
import cn.itcast.crm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginServiceImpl
 *
 * @author fenghaibang
 * @create 2018-06-29 下午4:42
 */
@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginDao loginDao;

    public UserInfo userLogin(UserInfo userInfo) {
        return loginDao.userLogin(userInfo);
    }
}
