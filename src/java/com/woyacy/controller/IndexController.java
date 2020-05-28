package com.woyacy.controller;

import com.woyacy.bean.ComprehensBean;
import com.woyacy.util.HttpUtil;
import com.woyacy.util.ObjectConvertJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 11:23
 */
@Controller
public class IndexController {


    @RequestMapping(value = "index")
    public String index(Model model){
        String url1 = "https://manage.zhou-yuanwai.com/comprehens/journalism.do";
        //查出全部文章
        String result = HttpUtil.sendGet(url1, "?uidpk=20");
        List<ComprehensBean> comprehensBeans = ObjectConvertJson.toBaseBean(result);
        model.addAttribute("object",comprehensBeans);
        return "index";
    }
}
