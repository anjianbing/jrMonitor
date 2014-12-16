package com.jd.jrjt.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangrui1
 * Date: 14-4-29
 * Time: 下午1:34
 * Description: 分页参数
 */
public class PageBean<T>  implements Serializable {
    private int DEF_PAGE_VIEW_SIZE = 10;

    /** 当前页 */
    private int pageNo = 1;
    /** 当前页显示记录条数 */
    private int pageSize;
    /** 取得查询总记录数 */
    private int totalRecord;
    /*** 总页数 **/
    private int totalPage;

    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象
    /**
     * (空)
     */
    public PageBean() {
        this.pageNo = 1;
        this.pageSize = DEF_PAGE_VIEW_SIZE;
    }

    /**
     * 根据当前显示页与每页显示记录数设置查询信息初始对象
     * @param pageNo 当前显示页号
     * @param pageSize 当前页显示记录条数
     */
    public PageBean(int pageNo, int pageSize) {
        this.pageNo = (pageNo <= 0) ? 1 : pageNo;
        this.pageSize = (pageSize <= 0) ? DEF_PAGE_VIEW_SIZE : pageSize;
    }

    /**
     * 取得当前显示页号
     * @return 当前显示页号
     */
    public int getPageNo() {
        return (pageNo <= 0) ? 1 : pageNo;
    }
    /**
     * 设置当前页
     * @param pageNo 当前页
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 取得当前显示页号最多显示条数
     * @return 当前显示页号最多显示条数
     */
    public int getPageSize() {
        return (pageSize <= 0) ? DEF_PAGE_VIEW_SIZE : pageSize;
    }
    /**
     * 设置当前页显示记录条数
     * @param pageSize 当前页显示记录条数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return  this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
