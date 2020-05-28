package com.woyacy.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 综合新闻实体类
 *
 * @author Administrator
 */
public class ComprehensBean implements Serializable {

    private Integer uidpk;
    /**
     * 分类实体
     */
    private ArticleCategoryBean articleCategoryBean;

    private String description;
    private String keyword;
    private String content;
    private Date createtime;
    private Date updatetime;
    private String createperson;
    private String title;
    private String source;
    private Integer pageview;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 缩略图
     */
    private ArticleThumbnailBean articleThumbnailBean;


    public Integer getUidpk() {
        return uidpk;
    }

    public void setUidpk(Integer uidpk) {
        this.uidpk = uidpk;
    }

    public ArticleCategoryBean getArticleCategoryBean() {
        return articleCategoryBean;
    }

    public void setArticleCategoryBean(ArticleCategoryBean articleCategoryBean) {
        this.articleCategoryBean = articleCategoryBean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public ArticleThumbnailBean getArticleThumbnailBean() {
        return articleThumbnailBean;
    }

    public void setArticleThumbnailBean(ArticleThumbnailBean articleThumbnailBean) {
        this.articleThumbnailBean = articleThumbnailBean;
    }

}
