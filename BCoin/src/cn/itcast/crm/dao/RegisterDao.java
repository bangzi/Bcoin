package cn.itcast.crm.dao;

import cn.itcast.crm.bean.UserInfo;

/**
 * RegisterDao
 *
 * @author fenghaibang
 * @create 2018-06-25 上午9:20
 */
public interface RegisterDao {
    void registerUserInfo(UserInfo userInfo);

    UserInfo checkUserIsExistWithUserInfo(UserInfo userInfo);
}
