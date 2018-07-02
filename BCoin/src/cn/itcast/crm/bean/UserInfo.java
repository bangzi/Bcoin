package cn.itcast.crm.bean;


import java.io.Serializable;
/**
 * UserInfo
 *
 * @author fenghaibang
 * @create 2018-06-22 下午6:18
 */
public class UserInfo implements Serializable {
    //客户名称
    private int id;
    private String userPhone;
    private String userPassword;
    private String userConfirmPassword;
    private String requestCode;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserConfirmPassword() {
        return userConfirmPassword;
    }
    public void setUserConfirmPassword(String userConfirmPassword) {
        this.userConfirmPassword = userConfirmPassword;
    }

    public String getRequestCode() {
        return requestCode;
    }
    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }
}
