package com.jd.jrjt.repository.level;

import com.jd.jrjt.entity.level.LastEducationInfo;
import com.jd.jrjt.repository.MyBatisRepository;
import com.jd.jrjt.util.PageBean;

import java.util.List;

/**
 * 描述：</b>SysLogDao<br>
 * @author：<a href="mailto:*@jd.com">系统生成</a>
 * @since：2014年06月06日 14时46分29秒 星期五 
 * @version:1.0
 */
@MyBatisRepository
public interface LastEducationInfoDao {

    public void save(LastEducationInfo info);


    public List<LastEducationInfo> getAll();
}
