package com.jd.jrjt.dao;

import com.jd.jrjt.entity.level.LastEducationInfo;
import com.jd.jrjt.entity.level.ResultBean;
import com.jd.jrjt.entity.level.SchoolCheck;

import com.jd.jrjt.util.MD5;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.ColumnCountGetFilter;
import org.apache.hadoop.hbase.filter.CompareFilter;

import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.protobuf.generated.CellProtos;
import org.apache.hadoop.hbase.protobuf.generated.FilterProtos;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * User: songyongzhong
 * Date: 14-3-17
 * Time: 下午1:43
 * ProjectName:jnessus
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);


    @Resource
    private HBaseDataSource hbaseSource;


    /**
     * 构建PUT对象
     *
     * @param info
     * @return
     */
    public Put buildPut(LastEducationInfo info) {
        System.out.println("开始构建");
        try {
            System.out.println("getDocumentNo = "+info.getDocumentNo());
            String rowkey = MD5.subMd5Code(info.getDocumentNo() == null ? "" : info.getDocumentNo());
            System.out.println("----"+rowkey + "---" + rowkey.getBytes());
            Put put = new Put(rowkey.getBytes());
            System.out.println(rowkey + "---" + rowkey.getBytes());
            put.add(Bytes.toBytes("s"), Bytes.toBytes("name"), Bytes.toBytes(info.getName()  == null ? "" :  info.getName()));
            System.out.println(info.getName() + "---" + Bytes.toBytes(info.getName()  == null ? "" : info.getName() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("documentNo"), Bytes.toBytes(info.getDocumentNo()  == null ? "" :  info.getDocumentNo() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("graduateYears"), Bytes.toBytes(info.getGraduateYears()  == null ? "" : info.getGraduateYears() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("birthday"), Bytes.toBytes(info.getBirthday()  == null ? "" : info.getBirthday() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("gender"), Bytes.toBytes(info.getGender()  == null ? "" :  info.getGender()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("age"), Bytes.toBytes(info.getAge()  == null ? "" :  info.getAge()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("originalAddress"), Bytes.toBytes(info.getOriginalAddress()  == null ? "" :  info.getOriginalAddress()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("verifyResult"), Bytes.toBytes(info.getVerifyResult()  == null ? "" :  info.getVerifyResult()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("levelNo"), Bytes.toBytes(info.getLevelNo()  == null ? "" :  info.getLevelNo()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("startTime"), Bytes.toBytes(info.getStartTime()  == null ? "" :  info.getStartTime()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("graduateTime"), Bytes.toBytes(info.getGraduateTime()  == null ? "" : info.getGraduateTime() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("studyStyle"), Bytes.toBytes(info.getStudyStyle()  == null ? "" :  info.getStudyStyle()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("studyType"), Bytes.toBytes(info.getStudyType()  == null ? "" : info.getStudyType() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("specialty"), Bytes.toBytes(info.getSpecialty()  == null ? "" :  info.getSpecialty()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("isKeySubject"), Bytes.toBytes(info.getIsKeySubject()  == null ? "" :  info.getIsKeySubject()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("degree"), Bytes.toBytes(info.getDegree()  == null ? "" :  info.getDegree()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("studyResult"), Bytes.toBytes(info.getStudyResult()  == null ? "" :  info.getStudyResult()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("photo"), Bytes.toBytes(info.getPhoto()  == null ? "" : info.getPhoto() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("photoStyle"), Bytes.toBytes(info.getPhotoStyle()  == null ? "" :  info.getPhotoStyle() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("college"), Bytes.toBytes(info.getCollege()  == null ? "" : info.getCollege() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("collegeOldName"), Bytes.toBytes(info.getCollegeOldName()  == null ? "" : info.getCollegeOldName() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("address"), Bytes.toBytes(info.getAddress()  == null ? "" :  info.getAddress()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("createDate"), Bytes.toBytes(info.getCreateDate()  == null ? "" :  info.getCreateDate()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("createYears"), Bytes.toBytes(info.getCreateYears()  == null ? "" :  info.getCreateYears()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("colgCharacter"), Bytes.toBytes(info.getColgCharacter()  == null ? "" : info.getColgCharacter() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("colgLevel"), Bytes.toBytes(info.getColgLevel()  == null ? "" :  info.getColgLevel()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("character"), Bytes.toBytes(info.getCharacter()  == null ? "" :  info.getCharacter()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("colgType"), Bytes.toBytes(info.getColgType()  == null ? "" :  info.getColgType()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("scienceBatch"), Bytes.toBytes(info.getScienceBatch()  == null ? "" : info.getScienceBatch() ));

            put.add(Bytes.toBytes("s"), Bytes.toBytes("artBatch"), Bytes.toBytes(info.getArtBatch()  == null ? "" :  info.getArtBatch()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("postDoctorNum"), Bytes.toBytes(info.getPostDoctorNum()  == null ? "" :  info.getPostDoctorNum()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("doctorDegreeNum"), Bytes.toBytes(info.getDoctorDegreeNum()  == null ? "" :  info.getDoctorDegreeNum()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("masterDegreeNuml"), Bytes.toBytes(info.getMasterDegreeNuml()  == null ? "" : info.getMasterDegreeNuml() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("academicianNum"), Bytes.toBytes(info.getAcademicianNum()  == null ? "" : info.getAcademicianNum() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("is211"), Bytes.toBytes(info.getIs211()  == null ? "" :  info.getIs211()));

            put.add(Bytes.toBytes("s"), Bytes.toBytes("manageDept"), Bytes.toBytes(info.getManageDept()  == null ? "" : info.getManageDept()  ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("keySubjectNum"), Bytes.toBytes(info.getKeySubjectNum()  == null ? "" : info.getKeySubjectNum() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("riskAndAdviceInfo"), Bytes.toBytes(info.getRiskAndAdviceInfo()  == null ? "" : info.getRiskAndAdviceInfo() ));

            put.add(Bytes.toBytes("s"), Bytes.toBytes("processed_tm"), Bytes.toBytes(System.currentTimeMillis()));
            System.out.println(info.getRiskAndAdviceInfo() + "---" + Bytes.toBytes(System.currentTimeMillis()));

            return put;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 构建PUT对象
     *
     * @param info
     * @return
     */
    public Put buildPut(ResultBean info) {
        System.out.println("开始构建");
        try {
            System.out.println("getDocumentNo = "+info.getDocumentNo());
            String rowkey = MD5.subMd5Code(info.getDocumentNo() == null ? "" : info.getDocumentNo());
            System.out.println("----"+rowkey + "---" + rowkey.getBytes());
            Put put = new Put(rowkey.getBytes());
            System.out.println(rowkey + "---" + rowkey.getBytes());
            put.add(Bytes.toBytes("e"), Bytes.toBytes("name"), Bytes.toBytes(info.getUserName()  == null ? "" :  info.getUserName()));
            System.out.println(info.getUserName() + "---" + Bytes.toBytes(info.getUserName()  == null ? "" : info.getUserName() ));
            put.add(Bytes.toBytes("e"), Bytes.toBytes("documentNo"), Bytes.toBytes(info.getDocumentNo()  == null ? "" :  info.getDocumentNo() ));
            put.add(Bytes.toBytes("e"), Bytes.toBytes("status"), Bytes.toBytes(info.getStatus()  == null ? "" : info.getStatus() ));
            put.add(Bytes.toBytes("e"), Bytes.toBytes("errorCode"), Bytes.toBytes(info.getErrorCode()  == null ? "" : info.getErrorCode() ));
            put.add(Bytes.toBytes("e"), Bytes.toBytes("errorMessage"), Bytes.toBytes(info.getErrorMessage()  == null ? "" :  info.getErrorMessage()));
            put.add(Bytes.toBytes("e"), Bytes.toBytes("processed_tm"), Bytes.toBytes(System.currentTimeMillis()));
            System.out.println("processed_tm---" + Bytes.toBytes(System.currentTimeMillis()));
            return put;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public Put buildPut(SchoolCheck school) {
        System.out.println("开始构建");
        try {
            System.out.println("getDocumentNo = "+school.getDocumentNo());
            String rowkey = MD5.subMd5Code(school.getDocumentNo() == null ? "" : school.getDocumentNo());
            System.out.println("----"+rowkey + "---" + rowkey.getBytes());
            Put put = new Put(rowkey.getBytes());
            System.out.println(rowkey + "---" + rowkey.getBytes());
            put.add(Bytes.toBytes("s"), Bytes.toBytes("name"), Bytes.toBytes(school.getName()  == null ? "" :  school.getName()));
            System.out.println(school.getName() + "---" + Bytes.toBytes(school.getName()  == null ? "" : school.getName() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("documentNo"), Bytes.toBytes(school.getDocumentNo()  == null ? "" :  school.getDocumentNo() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("startTime"), Bytes.toBytes(school.getStartTime()  == null ? "" : school.getStartTime() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("collegeLevel"), Bytes.toBytes(school.getCollegeLevel()  == null ? "" : school.getCollegeLevel() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("college"), Bytes.toBytes(school.getCollege()  == null ? "" :  school.getCollege()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("nameCheckResult"), Bytes.toBytes(school.getNameCheckResult()  == null ? "" : school.getNameCheckResult() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("documentNoCheckResult"), Bytes.toBytes(school.getDocumentNoCheckResult()  == null ? "" : school.getDocumentNoCheckResult() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("collegeLevelCheckResult"), Bytes.toBytes(school.getCollegeLevelCheckResult()  == null ? "" :  school.getCollegeLevelCheckResult()));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("collegeCheckResult"), Bytes.toBytes(school.getCollegeCheckResult()  == null ? "" : school.getCollegeCheckResult() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("startTimeCheckResult"), Bytes.toBytes(school.getStartTimeCheckResult()  == null ? "" : school.getStartTimeCheckResult() ));
            put.add(Bytes.toBytes("s"), Bytes.toBytes("processed_tm"), Bytes.toBytes(System.currentTimeMillis()));
            System.out.println("processed_tm---" + Bytes.toBytes(System.currentTimeMillis()));
            return put;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void saveSchoolCheck(SchoolCheck school){
        saveHbase(buildPut(school),"base_user_school");
    }

    public void saveHbase(Put put,String tableName){
        List<Put> putList = new ArrayList<Put>();
        if(put != null){
            putList.add(put);
        }

        System.out.println("保存成功-- putList.add(buildPut(info));");
        long aa = System.currentTimeMillis();

        try {
            importHbase(putList,tableName);
            System.out.println("保存成功--  importHbase(putList);");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long bb = System.currentTimeMillis();
        log.info("插入用时="+(bb-aa));
    }


    public void saveUserLevel(LastEducationInfo info){

        List<Put> putList = new ArrayList<Put>();
        System.out.println("保存成功--List<Put> putList = new ArrayList<Put>();");
        System.out.println("hbaseSource="+hbaseSource);
        Put put = buildPut(info);
        if(put != null){
            putList.add(put);
        }

        System.out.println("保存成功-- putList.add(buildPut(info));");
        long aa = System.currentTimeMillis();

        try {
            importHbase(putList);
            System.out.println("保存成功--  importHbase(putList);");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long bb = System.currentTimeMillis();
        log.info("插入用时="+(bb-aa));
    }

    public void saveUserLevel(ResultBean info){

        List<Put> putList = new ArrayList<Put>();
        System.out.println("保存成功--List<Put> putList = new ArrayList<Put>();");
        System.out.println("hbaseSource="+hbaseSource);
        Put put = buildPut(info);
        if(put != null){
            putList.add(put);
        }

        System.out.println("保存成功-- putList.add(buildPut(info));");
        long aa = System.currentTimeMillis();

        try {
            importHbase(putList);
            System.out.println("保存成功--  importHbase(putList);");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long bb = System.currentTimeMillis();
        log.info("插入用时="+(bb-aa));
    }

    /**
     * 导入数据到hbase
     *
     * @param
     * @throws Exception
     */
    public void importHbase(List<Put> list) throws Exception {
        HTableInterface table = null;
        table = hbaseSource.getTable("base_user_level");
        table.setWriteBufferSize(6 * 1024 * 1024);
        table.setAutoFlushTo(false);
        table.put(list);
        table.flushCommits();
        table.setAutoFlushTo(true);
        System.out.println("保存成功");
    }

    /**
     * 导入数据到hbase
     *
     * @param
     * @throws Exception
     */
    public void importHbase(List<Put> list,String tableName) throws Exception {
        HTableInterface table = null;
        table = hbaseSource.getTable(tableName);
        table.setWriteBufferSize(6 * 1024 * 1024);
        table.setAutoFlushTo(false);
        table.put(list);
        table.flushCommits();
        table.setAutoFlushTo(true);
        System.out.println("保存成功");
    }

    public HBaseDataSource getHbaseSource() {
        return hbaseSource;
    }

    public void setHbaseSource(HBaseDataSource hbaseSource) {
        this.hbaseSource = hbaseSource;
    }


    public static void main(String[]agrs)
    {
        String strDate = "2014-09-01 00:00:00" ;
        // 准备第一个模板，从字符串中提取出日期数字
        String pat1 = "yyyy-MM-dd HH:mm:ss" ;
        // 准备第二个模板，将提取后的日期数字变为指定的格式
        SimpleDateFormat sdf1 = new SimpleDateFormat(pat1) ;        // 实例化模板对象
        Date d = null ;
        try{
            d = sdf1.parse(strDate) ;   // 将给定的字符串中的日期提取出来
        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace() ;       // 打印异常信息
        }
        System.out.println(d.getTime());
    }


    public Long getTableCount(String tableName){
        long count = 0;
        long ourCount = 0;
        try {
            HTableInterface table  = hbaseSource.getTable(tableName);
            Filter filter = new SingleColumnValueFilter(Bytes
                    .toBytes("processed_tm"), null, CompareFilter.CompareOp.GREATER_OR_EQUAL, Bytes
                    .toBytes("1409500800000")); // 当列column1的值为aaa时进行查询
            Scan s = new Scan();
            s.setFilter(filter);
            ResultScanner rs = table.getScanner(s);

            for (Result r : rs) {
                long time = 0;
                for (Cell cell : r.rawCells()) {
                    System.out.print("列: " + Bytes.toString(CellUtil.cloneQualifier(cell)));
                    System.out.print("-- 值: " + Bytes.toString(CellUtil.cloneValue(cell)));
                    System.out.print("--时间戳: " + cell.getTimestamp());
                    time = cell.getTimestamp();
                }
                System.out.println("--");
                System.out.println("====1111111==="+ourCount);

                if(1409500800000L <= time && time <= 1412006400000L){
                    ourCount++;
                }
                count ++;
            }
            System.out.println("======="+ourCount);
        } catch (IOException e) {
                e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }


    public ResultScanner getTableScan(String tableName){
        long count = 0;
        long ourCount = 0;
        try {
            HTableInterface table  = hbaseSource.getTable(tableName);
            Filter filter = new SingleColumnValueFilter(Bytes
                    .toBytes("processed_tm"), null, CompareFilter.CompareOp.GREATER_OR_EQUAL, Bytes
                    .toBytes("1409500800000")); // 当列column1的值为aaa时进行查询
            Scan s = new Scan();
            s.setFilter(filter);
            ResultScanner rs = table.getScanner(s);
            return rs;
            /*for (Result r : rs) {
                long time = 0;
                for (Cell cell : r.rawCells()) {
                    System.out.print("列: " + Bytes.toString(CellUtil.cloneQualifier(cell)));
                    System.out.print("-- 值: " + Bytes.toString(CellUtil.cloneValue(cell)));
                    System.out.print("--时间戳: " + cell.getTimestamp());
                    time = cell.getTimestamp();
                }
                System.out.println("--");
                System.out.println("====1111111==="+ourCount);

                if(1409500800000L <= time && time <= 1412006400000L){
                    ourCount++;
                }
                count ++;
            }*/
           // System.out.println("======="+ourCount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
