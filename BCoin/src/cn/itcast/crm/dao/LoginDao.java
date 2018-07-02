package cn.itcast.crm.dao;

import cn.itcast.crm.bean.UserInfo;

/**
 * LoginDao
 *
 * @author fenghaibang
 * @create 2018-06-29 下午4:44
 */
public interface LoginDao {

    UserInfo userLogin(UserInfo userInfo);
}
