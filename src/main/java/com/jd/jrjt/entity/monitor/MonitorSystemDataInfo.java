package com.jd.jrjt.entity.monitor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by songyongzhong on 2014/12/16.
 */
public class MonitorSystemDataInfo {

    private Integer did;
    private Integer sid;
    private Integer rid;
    private String  sname;
    private String  uname;
    private String  rname;
    private String  isemail;
    private String  isphone;
    private String  error_log;
    private Date create_date;
    private Date modified_date;

    private String formaetDate;

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

    public String getError_log() {
        return error_log;
    }

    public void setError_log(String error_log) {
        this.error_log = error_log;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFormaetDate() {
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        return sFormat.format(create_date);
    }

    public void setFormaetDate(String formaetDate) {
        this.formaetDate = formaetDate;
    }
}
