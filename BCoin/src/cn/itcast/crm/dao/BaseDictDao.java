package cn.itcast.crm.dao;

import cn.itcast.crm.bean.BaseDict;

import java.util.List;

/**
 * BaseDictDao
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:38
 */
public interface BaseDictDao {
    //根据数据字典类别代码查询
    List<BaseDict> selectByTypecode(String typecode);
    //根据数据字典ID查询
    BaseDict selectByPrimaryKey(String dictId);
}
