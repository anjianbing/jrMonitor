package com.jd.jrjt.service.mortior;

import com.jd.jrjt.entity.monitor.MonitorSystemDataDetail;
import com.jd.jrjt.entity.monitor.MonitorSystemDataInfo;
import com.jd.jrjt.entity.monitor.MonitorSystemUserConfig;

import java.util.List;


/**
 * 用户管理类.
 * 
 * @author syz
 */
public interface MortorService {

    public List<MonitorSystemDataInfo> getList();

    public MonitorSystemDataDetail get(Integer did);

    public List<MonitorSystemUserConfig> getUserConfigList(Integer did);
}
