package com.woyacy.util;

import com.alibaba.fastjson.JSON;
import com.woyacy.bean.ComprehensBean;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 11:30
 */
public class ObjectConvertJson {

    /**
     * 把json 数组转化为 实体集合对象
     *
     * @param str json数组
     * @return 返回 List<ComprehensBean>实体
     */
    public static List<ComprehensBean> toBaseBean(String str) {
        return JSON.parseArray(str, ComprehensBean.class);
    }
}
