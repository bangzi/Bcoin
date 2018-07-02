package cn.itcast.crm.service;

import cn.itcast.crm.bean.UserInfo;

/**
 * RegisterService
 *
 * @author fenghaibang
 * @create 2018-06-25 上午9:14
 */
public interface RegisterService {
    public void registerUserInfo(UserInfo userInfo);

    public UserInfo checkUserIsExistWithUserInfo(UserInfo userInfo);

}
