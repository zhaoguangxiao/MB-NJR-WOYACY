package com.woyacy.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 综合网站新闻分类表
 *
 * @author Administrator
 */
public class ArticleCategoryBean implements Serializable {

    public static final Integer ZHONG_HE = 0;
    public static final Integer NIU_JIA_REN_PZ = 0;


    /**
     * 禁用
     */
    private static int DISABLE_CATEGORY = 1;


    private Long uidpk;
    private String categoryName;
    private int status;
    private Date createTime;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUidpk() {
        return uidpk;
    }

    public void setUidpk(Long uidpk) {
        this.uidpk = uidpk;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
