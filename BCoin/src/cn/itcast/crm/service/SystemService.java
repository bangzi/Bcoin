package cn.itcast.crm.service;

import cn.itcast.crm.bean.BaseDict;

import java.util.List;

/**
 * SystemService
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:42
 */
public interface SystemService {
    //根据类型查询数据字典
    public List<BaseDict> findBaseDictListByType(String typecode);

}
