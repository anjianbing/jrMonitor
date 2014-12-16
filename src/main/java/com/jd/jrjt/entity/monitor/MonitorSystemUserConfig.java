package com.jd.jrjt.entity.monitor;

/**
 * Created by songyongzhong on 2014/12/16.
 */
public class MonitorSystemUserConfig {

    private Integer uid; //用户id',
    private String  uname; //用户名称',
    private String  uemail; //用户邮箱',
    private String  uphone; //用户手机号',
    private String  state ;// 用户状态 0有效1无效',

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    private Integer sid; //系统id',
}
