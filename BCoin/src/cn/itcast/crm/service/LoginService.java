package cn.itcast.crm.service;

import cn.itcast.crm.bean.UserInfo;

/**
 * LoginService
 *
 * @author fenghaibang
 * @create 2018-06-29 下午4:41
 */
public interface LoginService {

    public UserInfo userLogin(UserInfo userInfo);
}
