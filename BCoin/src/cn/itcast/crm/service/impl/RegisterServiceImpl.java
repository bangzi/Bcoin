package cn.itcast.crm.service.impl;

import cn.itcast.crm.bean.UserInfo;
import cn.itcast.crm.dao.RegisterDao;
import cn.itcast.crm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegisterServiceImpl
 *
 * @author fenghaibang
 * @create 2018-06-25 上午9:15
 */
@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private RegisterDao registerDao;

    public void registerUserInfo(UserInfo userInfo) {
        registerDao.registerUserInfo(userInfo);
    }

    public UserInfo checkUserIsExistWithUserInfo(UserInfo userInfo) {

        return registerDao.checkUserIsExistWithUserInfo(userInfo);
    }
}
