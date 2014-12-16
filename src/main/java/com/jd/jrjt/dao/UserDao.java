package com.jd.jrjt.dao;





import com.jd.jrjt.entity.level.LastEducationInfo;
import com.jd.jrjt.entity.level.ResultBean;
import com.jd.jrjt.entity.level.SchoolCheck;
import org.apache.hadoop.hbase.client.ResultScanner;

import java.util.List;
import java.util.Map;

/**
 * User: chengchao
 * Date: 14-3-17
 * Time: 下午1:43
 * ProjectName:collectHbasePlatform
 */
public interface UserDao {
    /**
     * 保存从HADOOP传输过来的数据
     * @throws Exception
     */
    public void saveUserLevel(LastEducationInfo info);

    /**
     * 保存从HADOOP传输过来的数据
     * @throws Exception
     */
    public void saveUserLevel(ResultBean info);

    /**
     * 保存学生学籍核查结果
     * */
    public void saveSchoolCheck(SchoolCheck school);

    public Long getTableCount(String tableName);

    public ResultScanner getTableScan(String tableName);

}
