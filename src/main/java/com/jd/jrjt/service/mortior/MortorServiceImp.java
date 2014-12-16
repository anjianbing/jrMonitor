package com.jd.jrjt.service.mortior;


import com.jd.jrjt.entity.monitor.MonitorSystemDataDetail;
import com.jd.jrjt.entity.monitor.MonitorSystemDataInfo;
import com.jd.jrjt.entity.monitor.MonitorSystemUserConfig;
import com.jd.jrjt.repository.monitor.MonitorSystemDataDetailDao;
import com.jd.jrjt.repository.monitor.MonitorSystemDataInfoDao;
import com.jd.jrjt.repository.monitor.MonitorSystemUserConfigDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户管理类.
 *
 * @author syz
 */
// Spring Service Bean的标识.
@Service("mortorService")
@Transactional
public class MortorServiceImp implements MortorService {
    private static Logger logger = LoggerFactory.getLogger(MortorServiceImp.class);


    @Autowired
    private MonitorSystemDataInfoDao monitorSystemDataInfoDao;

    @Autowired
    private MonitorSystemDataDetailDao monitorSystemDataDetailDao;

    @Autowired
    private MonitorSystemUserConfigDao monitorSystemUserConfigDao;

    public List<MonitorSystemDataInfo> getList(){
        return monitorSystemDataInfoDao.getList();
    }


    public MonitorSystemDataDetail get(Integer did){
        return monitorSystemDataDetailDao.get(did);
    }

    public List<MonitorSystemUserConfig> getUserConfigList(Integer did){
        return monitorSystemUserConfigDao.getList(did);
    }



    public static void main(String[] args) {
        System.out.printf(1%2 + "");
    }

}
