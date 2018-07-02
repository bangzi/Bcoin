package cn.itcast.crm.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.bean.BaseDict;
import cn.itcast.crm.bean.Customer;
import cn.itcast.crm.bean.QueryVo;
import cn.itcast.crm.bean.UserInfo;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.service.RegisterService;
import cn.itcast.crm.service.SystemService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * CustomerController
 *
 * @author fenghaibang
 * @create 2018-06-15 上午8:41
 */
@Controller
public class CustomerController {

    // 依赖注入
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private RegisterService registerService;

    @Value("${customer.from.type}")
    private String FROM_TYPE;
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    @RequestMapping(value = "/customer")
    @ResponseBody
    public String showCumtomer() {
        return "redirect:/customer/list.action";
    }

    // 客户列表
//    @RequestMapping(value = "/customer/list")
//    @ResponseBody
//    public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows,
//                       String custName, String custSource,	String custIndustry, String custLevel, Model model) {
//
//        Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry,
//                custLevel);
//        model.addAttribute("page", customers);
//        //客户来源
//        List<BaseDict> fromType = systemService.findBaseDictListByType(FROM_TYPE);
//        //客户所属行业
//        List<BaseDict> industryType = systemService.findBaseDictListByType(INDUSTRY_TYPE);
//        //客户级别
//        List<BaseDict> levelType = systemService.findBaseDictListByType(LEVEL_TYPE);
//        model.addAttribute("fromType", fromType);
//        model.addAttribute("industryType", industryType);
//        model.addAttribute("levelType", levelType);
//        //参数回显
//        model.addAttribute("custName", custName);
//        model.addAttribute("custSource", custSource);
//        model.addAttribute("custIndustry", custIndustry);
//        model.addAttribute("custLevel", custLevel);
//        return "customer";
//    }
    //入口
    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model){

        List<BaseDict> fromType = systemService.findBaseDictListByType("002");
        List<BaseDict> industryType = systemService.findBaseDictListByType("001");
        List<BaseDict> levelType = systemService.findBaseDictListByType("006");
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        //通过四个条件  查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());

        return "customer";
    }

    @RequestMapping("/customer/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("/customer/update")
    @ResponseBody
    public String customerUpdate(Customer customer) {
        customerService.updateCustomer(customer);
        return "OK";
    }
    @RequestMapping("/customer/delete")
    @ResponseBody
    public String customerDelete(Long id) {
        customerService.deleteCustomer(id);
        return "OK";
    }

//    @RequestMapping("/customer/register")
//    @ResponseBody
//    public String registerUser(String userPhone, String userPassword, String requestCode) {
//        System.out.print(userPhone + userPassword + requestCode);
//        String str = userPhone + userPassword + requestCode;
//        return str;
//    }

//    @RequestMapping("/customer/register")
//    @ResponseBody
//    public String registerUser(UserInfo userInfo) {
//        System.out.print(userInfo);
//        userInfo.setId(1);
//        registerService.registerUserInfo(userInfo);
//        return "OK";
//    }



}
