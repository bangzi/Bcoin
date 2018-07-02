package cn.itcast.crm.dao;

import cn.itcast.crm.bean.Customer;
import cn.itcast.crm.bean.QueryVo;

import java.util.List;

/**
 * CustomerDao
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:40
 */
public interface CustomerDao {

    //总条数
    public Integer customerCountByQueryVo(QueryVo vo);
    //结果集
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);

    List<Customer> selectCustomerList(Customer customer);
    Integer selectCustomerListCount(Customer customer);
    Customer getCustomerById(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
