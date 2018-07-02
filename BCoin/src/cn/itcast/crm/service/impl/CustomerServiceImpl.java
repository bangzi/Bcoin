package cn.itcast.crm.service.impl;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.bean.Customer;
import cn.itcast.crm.bean.QueryVo;
import cn.itcast.crm.dao.BaseDictDao;
import cn.itcast.crm.dao.CustomerDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.crm.service.CustomerService;
import java.util.List;

/**
 * CustomerServiceImpl
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:42
 */


@Service("customerService")
//@Component
//@Transactional
public class CustomerServiceImpl implements CustomerService {
    // 定义dao属性
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BaseDictDao baseDictDao;

    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel) {
        Customer customer = new Customer();
        //判断客户名称(公司名称)
        if(StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        //判断客户信息来源
        if(StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        //判断客户所属行业
        if(StringUtils.isNotBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        //判断客户级别
        if(StringUtils.isNotBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        //当前页
        customer.setStart((page-1) * rows) ;
        //每页数
        customer.setRows(rows);
        //查询客户列表
        List<Customer> customers = customerDao.selectCustomerList(customer);
        //查询客户列表总记录数
        Integer count = customerDao.selectCustomerListCount(customer);
        //创建Page返回对象
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;

    }

    // 通过四个条件 查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();
        //每页数
        page.setSize(5);
        vo.setSize(5);
        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() -1)*vo.getSize());
            }
            if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
                vo.setCustName(vo.getCustName().trim());
            }
            if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            page.setTotal(customerDao.customerCountByQueryVo(vo));
            page.setRows(customerDao.selectCustomerListByQueryVo(vo));
        }
        return page;

    }

//    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;

    }


//    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);

    }


//    @Override
    public void deleteCustomer(Long id) {
        customerDao.deleteCustomer(id);

    }
}
