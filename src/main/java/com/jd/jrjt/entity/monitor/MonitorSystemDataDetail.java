package com.jd.jrjt.entity.monitor;

/**
 * Created by songyongzhong on 2014/12/16.
 */
public class MonitorSystemDataDetail {

    private Integer did;
    private Integer sid;
    private Integer rid;
    private String type;
    private String sdesc;
    private String  sname;
    private String  rname;
    private String  isemail;
    private String  isphone;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getIsemail() {
        return isemail;
    }

    public void setIsemail(String isemail) {
        this.isemail = isemail;
    }

    public String getIsphone() {
        return isphone;
    }

    public void setIsphone(String isphone) {
        this.isphone = isphone;
    }
}
