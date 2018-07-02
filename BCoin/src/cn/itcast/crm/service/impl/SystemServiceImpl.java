package cn.itcast.crm.service.impl;

import cn.itcast.crm.bean.BaseDict;
import cn.itcast.crm.dao.BaseDictDao;
import cn.itcast.crm.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SystemServiceImpl
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:42
 */

@Service("systemService")
@Component
public class SystemServiceImpl implements SystemService {
    @Autowired
    private BaseDictDao baseDictDao;
    //根据类型编号查询数据字典
    public List<BaseDict> findBaseDictListByType(String typecode) {

        return baseDictDao.selectByTypecode(typecode);
    }


}
