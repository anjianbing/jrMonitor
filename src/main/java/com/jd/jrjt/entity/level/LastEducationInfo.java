package com.jd.jrjt.entity.level;

/**
 * Created by songyongzhong on 2014/8/8.
 */
public class LastEducationInfo {

    //姓名
    private String name;
    //证件号码
    private String documentNo ;
    //毕业年限
    private String graduateYears ;
    //出生日期
    private String birthday ;
    //性别
    private String gender ;
    //年龄
    private String age ;
    //原始发证地区
    private String originalAddress ;
    //证件号码校验结果，1：通过，0：未通过，只有当校验位校验结果、地区位校验结果、出生日期位校验结果全为1时才返回1
    private String verifyResult ;
    //    学历证编号
    private String levelNo ;
    //    入学时间，格式YYYYMMDD
    private String startTime ;
    //    毕业时间，格式YYYY
    private String graduateTime ;
    //   学习形式，如：普通全日制、函授、脱产、网络教育、业余、夜大学、在职、不详
    private String studyStyle ;
    //    学历类别，如：研究生、成人、普通、网络教育、自学考试
    private String studyType ;
    //    所学专业
    private String specialty ;
    //是否国家重点学科
    private String isKeySubject ;
    //学历层次，如：博士研究生、硕士研究生、本科、专科、第二学士学位、第二专科、专科(高职)、专升本
    private String degree ;
    //毕业结论，毕业、结业、肄业之一
    private String studyResult ;
    //相片BASE64编码
    private String photo ;
    //相片格式：目前固定为JPG
    private String photoStyle ;
    //毕业院校
    private String college ;
    //毕业院校原名称
    private String collegeOldName ;
    //院校所在地
    private String address ;
    //   创建时间
    private String createDate ;
    //    创建年限
    private String createYears ;
    //    学校性质
    private String colgCharacter ;

    //办学层次
    private String colgLevel ;
    //办学性质
    private String character;
    //学校类别
    private String colgType;
    // 理科录取批次
    private String scienceBatch;
    //文科录取批次
    private String artBatch;
    //博士后流动站数
    private String postDoctorNum;
    //    博士点个数
    private String doctorDegreeNum;
    //    硕士点个数
    private String masterDegreeNuml;
    //院士人数
    private String academicianNum;
    //是否211院校:Y 是；N 否
    private String is211;
    //主管教育部门
    private String manageDept;
    //国家重点学科数
    private String keySubjectNum;

    //风险特征及授信建议--描述信息
    private String riskAndAdviceInfo;


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

    public String getGraduateYears() {
        return graduateYears;
    }

    public void setGraduateYears(String graduateYears) {
        this.graduateYears = graduateYears;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOriginalAddress() {
        return originalAddress;
    }

    public void setOriginalAddress(String originalAddress) {
        this.originalAddress = originalAddress;
    }

    public String getVerifyResult() {
        return verifyResult;
    }

    public void setVerifyResult(String verifyResult) {
        this.verifyResult = verifyResult;
    }

    public String getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(String levelNo) {
        this.levelNo = levelNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(String graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getStudyStyle() {
        return studyStyle;
    }

    public void setStudyStyle(String studyStyle) {
        this.studyStyle = studyStyle;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getIsKeySubject() {
        return isKeySubject;
    }

    public void setIsKeySubject(String isKeySubject) {
        this.isKeySubject = isKeySubject;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getStudyResult() {
        return studyResult;
    }

    public void setStudyResult(String studyResult) {
        this.studyResult = studyResult;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoStyle() {
        return photoStyle;
    }

    public void setPhotoStyle(String photoStyle) {
        this.photoStyle = photoStyle;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollegeOldName() {
        return collegeOldName;
    }

    public void setCollegeOldName(String collegeOldName) {
        this.collegeOldName = collegeOldName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateYears() {
        return createYears;
    }

    public void setCreateYears(String createYears) {
        this.createYears = createYears;
    }

    public String getColgCharacter() {
        return colgCharacter;
    }

    public void setColgCharacter(String colgCharacter) {
        this.colgCharacter = colgCharacter;
    }

    public String getColgLevel() {
        return colgLevel;
    }

    public void setColgLevel(String colgLevel) {
        this.colgLevel = colgLevel;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getColgType() {
        return colgType;
    }

    public void setColgType(String colgType) {
        this.colgType = colgType;
    }

    public String getScienceBatch() {
        return scienceBatch;
    }

    public void setScienceBatch(String scienceBatch) {
        this.scienceBatch = scienceBatch;
    }

    public String getArtBatch() {
        return artBatch;
    }

    public void setArtBatch(String artBatch) {
        this.artBatch = artBatch;
    }

    public String getPostDoctorNum() {
        return postDoctorNum;
    }

    public void setPostDoctorNum(String postDoctorNum) {
        this.postDoctorNum = postDoctorNum;
    }

    public String getDoctorDegreeNum() {
        return doctorDegreeNum;
    }

    public void setDoctorDegreeNum(String doctorDegreeNum) {
        this.doctorDegreeNum = doctorDegreeNum;
    }

    public String getMasterDegreeNuml() {
        return masterDegreeNuml;
    }

    public void setMasterDegreeNuml(String masterDegreeNuml) {
        this.masterDegreeNuml = masterDegreeNuml;
    }

    public String getAcademicianNum() {
        return academicianNum;
    }

    public void setAcademicianNum(String academicianNum) {
        this.academicianNum = academicianNum;
    }

    public String getIs211() {
        return is211;
    }

    public void setIs211(String is211) {
        this.is211 = is211;
    }

    public String getManageDept() {
        return manageDept;
    }

    public void setManageDept(String manageDept) {
        this.manageDept = manageDept;
    }

    public String getKeySubjectNum() {
        return keySubjectNum;
    }

    public void setKeySubjectNum(String keySubjectNum) {
        this.keySubjectNum = keySubjectNum;
    }

    public String getRiskAndAdviceInfo() {
        return riskAndAdviceInfo;
    }

    public void setRiskAndAdviceInfo(String riskAndAdviceInfo) {
        this.riskAndAdviceInfo = riskAndAdviceInfo;
    }

    public Long getProcessedDt() {
        return processedDt;
    }

    public void setProcessedDt(Long processedDt) {
        this.processedDt = processedDt;
    }
}
