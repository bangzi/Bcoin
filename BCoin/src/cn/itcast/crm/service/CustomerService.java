package cn.itcast.crm.service;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.bean.Customer;
import cn.itcast.crm.bean.QueryVo;

/**
 * CustomerService
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:41
 */
public interface CustomerService {

    // 查询客户列表
    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel);

    // 通过四个条件 查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo);

    public Customer getCustomerById(Long id);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Long id);
}
