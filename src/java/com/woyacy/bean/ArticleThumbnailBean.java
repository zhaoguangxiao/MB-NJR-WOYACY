package com.woyacy.bean;

import java.io.Serializable;

/**
 * 新闻缩略图实体类
 *
 * @author Administrator
 */
public class ArticleThumbnailBean implements Serializable {

    private Integer uidpk;
    private String thumbnailurl;
    private String thumbnailName;


    public Integer getUidpk() {
        return uidpk;
    }

    public void setUidpk(Integer uidpk) {
        this.uidpk = uidpk;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }

}
