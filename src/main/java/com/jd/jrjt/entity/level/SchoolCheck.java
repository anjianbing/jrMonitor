package com.jd.jrjt.entity.level;

import java.util.Date;

/**
 * Created by songyongzhong on 2014/8/13.
 */
public class SchoolCheck {
    //姓名
    private String name;
    //证件号码
    private String documentNo;
    //    入学年份
    private String startTime;
    //    学历层次
    private String collegeLevel;
    //毕业院校A
    private String college;
    //
    private String nameCheckResult;

    private String documentNoCheckResult;

    private String collegeLevelCheckResult;

    private String collegeCheckResult;

    private String startTimeCheckResult;

    private String graduateTimeCheckResult;

    private String treatErrorCode;

    private String errorMessage;

    private Date processedTm;

    private Long processedDt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCollegeLevel() {
        return collegeLevel;
    }

    public void setCollegeLevel(String collegeLevel) {
        this.collegeLevel = collegeLevel;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getNameCheckResult() {
        return nameCheckResult;
    }

    public void setNameCheckResult(String nameCheckResult) {
        this.nameCheckResult = nameCheckResult;
    }

    public String getDocumentNoCheckResult() {
        return documentNoCheckResult;
    }

    public void setDocumentNoCheckResult(String documentNoCheckResult) {
        this.documentNoCheckResult = documentNoCheckResult;
    }

    public String getCollegeLevelCheckResult() {
        return collegeLevelCheckResult;
    }

    public void setCollegeLevelCheckResult(String collegeLevelCheckResult) {
        this.collegeLevelCheckResult = collegeLevelCheckResult;
    }

    public String getCollegeCheckResult() {
        return collegeCheckResult;
    }

    public void setCollegeCheckResult(String collegeCheckResult) {
        this.collegeCheckResult = collegeCheckResult;
    }

    public String getStartTimeCheckResult() {
        return startTimeCheckResult;
    }

    public void setStartTimeCheckResult(String startTimeCheckResult) {
        this.startTimeCheckResult = startTimeCheckResult;
    }

    public String getGraduateTimeCheckResult() {
        return graduateTimeCheckResult;
    }

    public void setGraduateTimeCheckResult(String graduateTimeCheckResult) {
        this.graduateTimeCheckResult = graduateTimeCheckResult;
    }

    public String getTreatErrorCode() {
        return treatErrorCode;
    }

    public void setTreatErrorCode(String treatErrorCode) {
        this.treatErrorCode = treatErrorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setProcessedTm(Date processedTm) {
        this.processedTm = processedTm;
    }

    public Long getProcessedDt() {
        return processedDt;
    }

    public void setProcessedDt(Long processedDt) {
        this.processedDt = processedDt;
    }

}
