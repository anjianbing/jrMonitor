package com.jd.jrjt.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangrui1
 * Date: 14-4-29
 * Time: 上午11:38
 * Description: ${TODO}
 */
public class Page<T> implements Serializable {
    /** 查询结果 */
    private List<?> listResult;
    /** 分页信息Bean */
    private PageBean pageBean;

    /**
     * (空)
     */
    public Page() {}

    /**
     * 根据查询结果、分页信息构造
     * @param listResult 查询结果
     * @param pageBean 分页信息Bean
     */
    public Page(List<?> listResult, PageBean pageBean) {
        this.listResult = listResult;
        this.pageBean = pageBean;
    }

    /**
     * 取得查询结果
     * @return 查询结果
     */
    public List<?> getListResult() {
        return listResult;
    }
    /**
     * 设置查询结果
     * @param listResult 查询结果
     */
    public void setListResult(List<?> listResult) {
        this.listResult = listResult;
    }

    /**
     * 取得分页信息Bean
     * @return 分页信息Bean
     */
    public PageBean getPageBean() {
        return pageBean;
    }
    /**
     * 设置分页信息Bean
     * @param pageBean 分页信息Bean
     */
    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }
}
