package com.jd.jrjt.util;

import com.google.gson.Gson;
import com.jd.jrjt.entity.level.LastEducationInfo;
import com.jd.jrjt.entity.level.ResultBean;
import com.jd.jrjt.entity.level.SchoolCheck;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;


/**
 * Created by songyongzhong on 2014/8/7.
 */
public class XMLHelper {

    private static final Log logger = LogFactory.getLog(XMLHelper.class);

    public static void main(String[] args) {
    	//System.out.println(formatXML(createSchoolXML("dddd", "140625555", "2002","ddd","eeee")));
        //System.out.println(createSchoolXML("dddd", "140625555", "2002","ddd","eeee"));


        String xml = "<cisReports><cisReport reportID=\"2014092615001374\" buildEndTime=\"2014-09-26 15:19:08\" queryReasonID=\"99\" subReportTypes=\"11109\" treatResult=\"1\" subReportTypesShortCaption=\"1、高等教育学籍信息核查 \" hasSystemError=\"false\" isFrozen=\"false\">\n" +
                " <queryConditions>\n" +
                "                <item>\n" +
                "                        <name>name</name>\n" +
                "                        <caption>姓名</caption>\n" +
                "                        <value>吴寒</value>\n" +
                "                </item>\n" +
                "                <item>\n" +
                "                        <name>documentNo</name>\n" +
                "                        <caption>证件号码</caption>\n" +
                "                        <value>211381198601230022</value>\n" +
                "                </item>\n" +
                "                <item>\n" +
                "                        <name>collegeLevel</name>\n" +
                "                        <caption>学历层次</caption>\n" +
                "                        <value>本科</value>\n" +
                "                </item>\n" +
                "                <item>\n" +
                "                        <name>college</name>\n" +
                "                        <caption>所在院校</caption>\n" +
                "                        <value>北京大学</value>\n" +
                "                </item>\n" +
                "                <item>\n" +
                "                        <name>startTime</name>\n" +
                "                        <caption>入学年份</caption>\n" +
                "                        <value>2012</value>\n" +
                "                </item>\n" +
                "        </queryConditions>\n" +
                "        <educationInSchoolCheck subReportType=\"11109\" subReportTypeCost=\"11109\" treatResult=\"3\" treatErrorCode=\"201\" errorMessage=\"远程查询超时\">\n" +
                "        </educationInSchoolCheck></cisReport>\n" +
                "</cisReports>";

        SchoolCheck sc = getSchoolCheckResult(xml);
        Gson gson = new Gson();
        System.out.println(gson.toJson(sc));
    }

    public static String createParmXml(String name, String documentNo, String graduateYear, String levelNo) {
        Document doc = DocumentHelper.createDocument();  //创建文档
        doc.setXMLEncoding("GBK");
        Element condition = addStrutsElement(doc,"25134");

        addItemElement(condition, "name", name);
        addItemElement(condition, "documentNo", documentNo);
        if (graduateYear != null) {
            addItemElement(condition, "graduateYear", graduateYear);
        }
        if (levelNo != null) {
            addItemElement(condition, "levelNo", levelNo);
        }
        addItemElement(condition, "subreportIDs", "11110");
        return doc.asXML();
    }

    public static String createParmXml(String name, String documentNo, String graduateYear) {
        if (graduateYear != null && Integer.valueOf(graduateYear) >= 2002) {
            return createParmXml(name, documentNo, graduateYear, null);
        } else {
            return null;
        }
    }

    public static String createSchoolXML(String name, String documentNo,String startTime,String collegeLevel,String college){
        System.out.println("进入XML层。。。。。。。。。。。。。。。。");
        Document doc = DocumentHelper.createDocument();  //创建文档
        doc.setXMLEncoding("GBK");
        Element condition = addStrutsElement(doc,"25158");

        addItemElement(condition, "name", name);
        addItemElement(condition, "documentNo", documentNo);
        if (startTime != null) {
            addItemElement(condition, "startTime", startTime);
        }
        if (collegeLevel != null) {
            addItemElement(condition, "collegeLevel", collegeLevel);
        }
        if (college != null) {
            addItemElement(condition, "college", college);
        }
        System.out.println("22222222222222222。。。。。。。。。。。。。。。。");

        addItemElement(condition, "subreportIDs", "11109");
        System.out.println("进入XML层。。。。。。。。。。。。。。。。"+doc.asXML());
        return doc.asXML();


    }

    public static Element addStrutsElement(Document doc,String queryType) {
        Element conditions = doc.addElement("conditions");
        Element condition = conditions.addElement("condition");
        condition.addAttribute("queryType", queryType);
        return condition;
    }

    public static void addItemElement(Element el, String name, String value) {
        Element item = el.addElement("item");
        item.addElement("name").setText(name);
        item.addElement("value").setText(value);
    }



    public static LastEducationInfo readXML(String xml) {
    	System.out.println("xml=="+xml);
        Document doc = formatXML(xml);
        if(doc != null){
            Element rootElt = doc.getRootElement(); // 获取根节点
            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
            LastEducationInfo info = getXMLData(rootElt.element("cisReport"));
            // Gson gson = new Gson();
            //return gson.toJson(info);
            return info;
        }
        return null;
    }


    private static LastEducationInfo getXMLData(Element cisReport){
        LastEducationInfo info = new LastEducationInfo();
        Element lastEducationInfo = cisReport.element("lastEducationInfo");
        Element personBaseInfo = lastEducationInfo.element("personBaseInfo");
        String name = getElementText(personBaseInfo,"name");//personBaseInfo.element("name").getText();
        info.setName(name);
        logger.info(name);
        System.out.println(name);

        String documentNo = getElementText(personBaseInfo,"documentNo");//personBaseInfo.element("documentNo").getText();
        info.setDocumentNo(documentNo);
        logger.info(documentNo);
        System.out.println(documentNo);

        String degree = getElementText(personBaseInfo,"degree");//personBaseInfo.element("degree").getText();
        info.setDegree(degree);
        logger.info(degree);
        System.out.println(degree);

        String specialty = getElementText(personBaseInfo,"specialty");//personBaseInfo.element("specialty").getText();
        info.setSpecialty(specialty);
        logger.info(specialty);
        System.out.println(specialty);

        String college = getElementText(personBaseInfo,"college");//personBaseInfo.element("college").getText();
        info.setCollege(college);
        logger.info(college);
        System.out.println(college);

        String graduateTime = getElementText(personBaseInfo,"graduateTime");//personBaseInfo.element("graduateTime").getText();
        info.setGraduateTime(graduateTime);
        logger.info(graduateTime);
        System.out.println(graduateTime);

        String graduateYears = getElementText(personBaseInfo,"graduateYears");//personBaseInfo.element("graduateYears").getText();
        info.setGraduateYears(graduateYears);
        logger.info(graduateYears);
        System.out.println(graduateYears);

        String birthday = getElementText(personBaseInfo,"birthday");//personBaseInfo.element("birthday").getText();
        info.setBirthday(birthday);
        logger.info(birthday);
        System.out.println(birthday);

        String gender = getElementText(personBaseInfo,"gender");//personBaseInfo.element("gender").getText();
        info.setGender(gender);
        logger.info(gender);
        System.out.println(gender);

        String age = getElementText(personBaseInfo,"age");//personBaseInfo.element("age").getText();
        info.setAge(age);
        logger.info(age);
        System.out.println(age);

        String originalAddress = getElementText(personBaseInfo,"originalAddress");//personBaseInfo.element("originalAddress").getText();
        info.setOriginalAddress(originalAddress);
        logger.info(originalAddress);
        System.out.println(originalAddress);

        String verifyResult = getElementText(personBaseInfo,"verifyResult");//personBaseInfo.element("verifyResult").getText();
        info.setVerifyResult(verifyResult);
        logger.info(verifyResult);
        System.out.println(verifyResult);

        Element educationInfo = lastEducationInfo.element("educationInfo");
        if(educationInfo != null){
            Element item = educationInfo.element("item");
            if(item != null){
                Element degreeInfo = item.element("degreeInfo");
                String levelNo = getElementText(degreeInfo,"levelNo");//degreeInfo.element("levelNo").getText();
                info.setLevelNo(levelNo);
                logger.info(levelNo);
                System.out.println(levelNo);

                String startTime = getElementText(degreeInfo,"startTime");//degreeInfo.element("startTime").getText();
                info.setStartTime(startTime);
                logger.info(startTime);
                System.out.println(startTime);

                String studyStyle = getElementText(degreeInfo,"studyStyle");//degreeInfo.element("studyStyle").getText();
                info.setStudyStyle(studyStyle);
                logger.info(studyStyle);
                System.out.println(studyStyle);

                String studyType = getElementText(degreeInfo,"studyType");//degreeInfo.element("studyType").getText();
                info.setStudyType(studyType);
                logger.info(studyType);
                System.out.println(studyType);

                String isKeySubject = getElementText(degreeInfo,"isKeySubject");//degreeInfo.element("isKeySubject").getText();
                info.setIsKeySubject(isKeySubject);
                logger.info(isKeySubject);
                System.out.println(isKeySubject);

                String studyResult = getElementText(degreeInfo,"studyResult");//degreeInfo.element("studyResult").getText();
                info.setStudyResult(studyResult);
                logger.info(studyResult);
                System.out.println(name);

                String photo = getElementText(degreeInfo,"photo");//degreeInfo.element("photo").getText();
                info.setPhoto(photo);
                logger.info(photo);
                System.out.println(photo);

                String photoStyle = getElementText(degreeInfo,"photoStyle");//degreeInfo.element("photoStyle").getText();
                info.setPhotoStyle(photoStyle);
                logger.info(photoStyle);
                System.out.println(photoStyle);


                Element collegeInfo = item.element("collegeInfo");

                String collegeOldName = getElementText(collegeInfo,"collegeOldName");//collegeInfo.element("collegeOldName").getText();
                info.setCollegeOldName(collegeOldName);
                logger.info(collegeOldName);
                System.out.println(collegeOldName);

                String address = getElementText(collegeInfo,"address");//collegeInfo.element("address").getText();
                info.setAddress(address);
                logger.info(address);
                System.out.println(address);

                String createDate = getElementText(collegeInfo,"createDate");//collegeInfo.element("createDate").getText();
                info.setCreateDate(createDate);
                logger.info(createDate);
                System.out.println(createDate);

                String createYears = getElementText(collegeInfo,"createYears");//collegeInfo.element("createYears").getText();
                info.setCreateYears(createYears);
                logger.info(createYears);
                System.out.println(createYears);

                String colgCharacter = getElementText(collegeInfo,"colgCharacter");//collegeInfo.element("colgCharacter").getText();
                info.setColgCharacter(colgCharacter);
                logger.info(colgCharacter);
                System.out.println(colgCharacter);

                String colgLevel = getElementText(collegeInfo,"colgLevel");//collegeInfo.element("colgLevel").getText();
                info.setColgLevel(colgLevel);
                logger.info(colgLevel);
                System.out.println(colgLevel);

                String character = getElementText(collegeInfo,"character");//collegeInfo.element("character").getText();
                info.setCharacter(character);
                logger.info(character);
                System.out.println(character);

                String colgType = getElementText(collegeInfo,"colgType");//collegeInfo.element("colgType").getText();
                info.setColgType(colgType);
                logger.info(colgType);
                System.out.println(colgType);

                String scienceBatch = getElementText(collegeInfo,"scienceBatch");//collegeInfo.element("scienceBatch").getText();
                info.setScienceBatch(scienceBatch);
                logger.info(scienceBatch);
                System.out.println(scienceBatch);

                String artBatch = getElementText(collegeInfo,"artBatch");//collegeInfo.element("artBatch").getText();
                info.setArtBatch(artBatch);
                logger.info(artBatch);
                System.out.println(artBatch);


                String postDoctorNum = getElementText(collegeInfo,"postDoctorNum");//collegeInfo.element("postDoctorNum").getText();
                info.setPostDoctorNum(postDoctorNum);
                logger.info(postDoctorNum);
                System.out.println(postDoctorNum);

                String doctorDegreeNum = getElementText(collegeInfo,"doctorDegreeNum");//collegeInfo.element("doctorDegreeNum").getText();
                info.setDoctorDegreeNum(doctorDegreeNum);
                logger.info(doctorDegreeNum);
                System.out.println(doctorDegreeNum);

                String masterDegreeNum = getElementText(collegeInfo,"masterDegreeNum");//collegeInfo.element("masterDegreeNum").getText();
                info.setMasterDegreeNuml(masterDegreeNum);
                logger.info(masterDegreeNum);
                System.out.println(masterDegreeNum);

                String academicianNum = getElementText(collegeInfo,"academicianNum");//collegeInfo.element("academicianNum").getText();
                info.setAcademicianNum(academicianNum);
                logger.info(academicianNum);
                System.out.println(academicianNum);

                String is211 = getElementText(collegeInfo,"is211");//collegeInfo.element("is211").getText();
                info.setIs211(is211);
                logger.info(is211);
                System.out.println(is211);

                String manageDept = getElementText(collegeInfo,"manageDept");//collegeInfo.element("manageDept").getText();
                info.setManageDept(manageDept);
                logger.info(manageDept);
                System.out.println(manageDept);

                String keySubjectNum = getElementText(collegeInfo,"keySubjectNum");//collegeInfo.element("keySubjectNum").getText();
                info.setKeySubjectNum(keySubjectNum);
                logger.info(keySubjectNum);
                System.out.println(keySubjectNum);
            }
        }






        String riskAndAdviceInfo = getElementText(lastEducationInfo,"riskAndAdviceInfo");// lastEducationInfo.element("riskAndAdviceInfo").getText();
        info.setRiskAndAdviceInfo(riskAndAdviceInfo);
        logger.info(riskAndAdviceInfo);
        System.out.println(riskAndAdviceInfo);

        return info;

    }


    private static String getElementText(Element el,String elName){
        if(el != null){
            Element subEl = el.element(elName);
            if(subEl != null){
                return subEl.getText();
            }
        }

        return null;
    }

    private static String getAttributeValue(Element el,String elName){
        if(el != null){
            return el.attributeValue(elName);

        }

        return null;
    }


    private static Document formatXML(String xml){
        Document doc = null;
        try {
            // 读取并解析XML文档
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来
            //
            // SAXReader reader = new SAXReader(); //User.hbm.xml表示你要解析的xml文档
            // Document document = reader.read(new File("User.hbm.xml"));
            // 下面的是通过解析xml字符串的
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            return doc;
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getBase64Char(String xml){
        Document doc = null;
        if(xml != null && !"".equals(xml)){
            doc = formatXML(xml);
        }
        String base64 = null;
        if(doc != null){
            Element rootElt = doc.getRootElement(); // 获取根节点
            Element el = rootElt.element("returnValue");
            if(el != null){
                base64 = el.getText();
            }

        }
        return base64;

    }

    public static ResultBean getMsgError(String xml){
        logger.info("错误信息"+xml);
        ResultBean bean = new ResultBean();
        Document doc = null;
        if(xml != null && !"".equals(xml)){
            doc = formatXML(xml);
        }
        String base64 = null;
        if(doc != null){

            Element rootElt = doc.getRootElement(); // 获取根节点
            Element status = rootElt.element("status");
            if(status != null){
                bean.setStatus(status.getText());
            }

            Element errorCode = rootElt.element("errorCode");
            if(errorCode != null){
                bean.setStatus(errorCode.getText());
            }

            Element errorMessage = rootElt.element("errorMessage");
            if(errorMessage != null){
                bean.setStatus(errorMessage.getText());
            }

        }
        return bean;

    }

    

    public static SchoolCheck getSchoolCheckResult(String xml){
        Document doc = null;
        if(xml != null && !"".equals(xml)){
            doc = formatXML(xml);
        }
        SchoolCheck sc = null;
        if(doc != null){
            Element rootElt = doc.getRootElement(); // 获取根节点
            sc = getSchoolXMLData(rootElt.element("cisReport"));
        }
        return sc;
    }

    private static SchoolCheck getSchoolXMLData(Element root){
        SchoolCheck sc = new SchoolCheck();

        Element lastEducationInfo = root.element("queryConditions");
        for (Iterator it = lastEducationInfo.elementIterator(); it.hasNext();) {
            Element item = (Element) it.next();
            String name = getElementText(item,"name");
            String value = getElementText(item,"value");

            if("name".equals(name)){
                sc.setName(value);
            }else if("documentNo".equals(name)){
                sc.setDocumentNo(value);
            }else if("startTime".equals(name)){
                sc.setStartTime(value);
            }else if("collegeLevel".equals(name)){
                sc.setCollegeLevel(value);
            }else if("college".equals(name)){
                sc.setCollege(value);
            }
         }

        Element educationInSchoolCheck = root.element("educationInSchoolCheck");
        String treatErrorCode = getAttributeValue(educationInSchoolCheck,"treatErrorCode");
        if(treatErrorCode != null && !"".equals(treatErrorCode)){
            sc.setTreatErrorCode(treatErrorCode);
        }

        String errorMessage = getAttributeValue(educationInSchoolCheck,"errorMessage");
        if(errorMessage != null && !"".equals(errorMessage)){
            sc.setErrorMessage(errorMessage);
        }


        String nameCheckResult = getElementText(educationInSchoolCheck,"nameCheckResult");
        if(nameCheckResult != null && !"".equals(nameCheckResult)){
            sc.setNameCheckResult(nameCheckResult);
        }

        String documentNoCheckResult = getElementText(educationInSchoolCheck,"documentNoCheckResult");
        if(documentNoCheckResult != null && !"".equals(documentNoCheckResult)){
            sc.setDocumentNoCheckResult(documentNoCheckResult);
        }

        String collegeLevelCheckResult = getElementText(educationInSchoolCheck,"collegeLevelCheckResult");
        if(collegeLevelCheckResult != null && !"".equals(collegeLevelCheckResult)){
            sc.setCollegeLevelCheckResult(collegeLevelCheckResult);
        }

        String collegeCheckResult = getElementText(educationInSchoolCheck,"collegeCheckResult");
        if(collegeCheckResult != null && !"".equals(collegeCheckResult)){
            sc.setCollegeCheckResult(collegeCheckResult);
        }

        String startTimeCheckResult = getElementText(educationInSchoolCheck,"startTimeCheckResult");//graduateTimeCheckResult
        if(startTimeCheckResult != null && !"".equals(startTimeCheckResult)){
            sc.setStartTimeCheckResult(startTimeCheckResult);
        }

        String graduateTimeCheckResult = getElementText(educationInSchoolCheck,"graduateTimeCheckResult");//
        if(graduateTimeCheckResult != null && !"".equals(graduateTimeCheckResult)){
            sc.setGraduateTimeCheckResult(graduateTimeCheckResult);
        }

        return sc;
    }
    
    
    public static LastEducationInfo getLastEducationInfoResult(String xml){
       Document doc = formatXML(xml);
        LastEducationInfo sc = null;
        if(doc != null){
            Element rootElt = doc.getRootElement(); // 获取根节点
            sc = getLastEducationInfoData(rootElt.element("cisReport"));

    
    
    
        }
        return sc;
   }
    
    
    private static LastEducationInfo getLastEducationInfoData(Element root){
    	LastEducationInfo sc = new LastEducationInfo();

        Element lastEducationInfo = root.element("queryConditions");
        for (Iterator it = lastEducationInfo.elementIterator(); it.hasNext();) {
            Element item = (Element) it.next();
            String name = getElementText(item,"name");
            String value = getElementText(item,"value");

            if("name".equals(name)){
                sc.setName(value);
            }else if("documentNo".equals(name)){
                sc.setDocumentNo(value);
            }else if("levelNo".equals(name)){
                sc.setStartTime(value);
            }else if("graduateYear".equals(name)){
                sc.setCollege(value);
            }
         }

//       Element educationInSchoolCheck = root.element("educationInSchoolCheck");
//        String nameCheckResult = getElementText(educationInSchoolCheck,"nameCheckResult");
//        sc.setNameCheckResult(nameCheckResult);
//        sc.setBirthday(birthday);
//        String documentNoCheckResult = getElementText(educationInSchoolCheck,"documentNoCheckResult");
//        sc.setDocumentNoCheckResult(documentNoCheckResult);
//        String collegeLevelCheckResult = getElementText(educationInSchoolCheck,"collegeLevelCheckResult");
//        sc.setCollegeLevelCheckResult(collegeLevelCheckResult);
//        String collegeCheckResult = getElementText(educationInSchoolCheck,"collegeCheckResult");
//        sc.setCollegeCheckResult(collegeCheckResult);
//        String startTimeCheckResult = getElementText(educationInSchoolCheck,"startTimeCheckResult");
//        sc.setStartTimeCheckResult(startTimeCheckResult);
        return sc;
    }
}
