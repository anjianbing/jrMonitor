package com.jd.jrjt.repository.monitor;


import com.jd.jrjt.entity.monitor.MonitorSystemDataDetail;
import com.jd.jrjt.entity.monitor.MonitorSystemDataInfo;
import com.jd.jrjt.repository.MyBatisRepository;

import java.util.List;

/**
 * 描述：</b>SysLogDao<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * @since：2014年06月06日 14时46分29秒 星期五 
 * @version:1.0
 */
@MyBatisRepository
public interface MonitorSystemDataDetailDao {


    public MonitorSystemDataDetail get(Integer did);
}
