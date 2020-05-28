package com.woyacy.controller;

import com.alibaba.fastjson.JSON;
import com.woyacy.bean.ComprehensBean;
import com.woyacy.util.HttpUtil;
import com.woyacy.util.ObjectConvertJson;
import com.woyacy.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0
 * @date 2020/5/27 14:23
 */
@Controller
@RequestMapping(value = "journalism")
public class JournalismController {

    @RequestMapping
    public String toJournalismList(@RequestParam Map<String, String> map, Model model) {
        String url1 = "https://manage.zhou-yuanwai.com/comprehens/journalism.do";
        //查出全部文章
        String result = HttpUtil.sendGet(url1, "?uidpk=20");
        List<ComprehensBean> comprehensBeans = ObjectConvertJson.toBaseBean(result);

        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "0");
        }

        // 参数为当前页码、每页显示条数、查询的列表集合
        PageUtil pageInfo = new PageUtil(Integer.valueOf(map.get("currentPage")), 5, comprehensBeans);
        model.addAttribute("userDTOList", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "news";
    }


    @RequestMapping(value = "{uidpk}")
    public String toDetailsPage(@PathVariable("uidpk") Integer uidpk,
                                Model model) {

        String url = "https://manage.zhou-yuanwai.com/comprehens/findOne.do";
        if (null != uidpk) {
            String result = HttpUtil.sendGet(url, "?uidpk=" + uidpk);
            model.addAttribute("journalism", JSON.parseObject(result, ComprehensBean.class));
        }


        String url1 = "https://manage.zhou-yuanwai.com/comprehens/journalism.do";
        //查出全部文章
        String result = HttpUtil.sendGet(url1, "?uidpk=20");
        List<ComprehensBean> comprehensBeans = ObjectConvertJson.toBaseBean(result);
        model.addAttribute("random", randomObject(comprehensBeans));

        return "newsInfo";
    }



    private List<ComprehensBean> randomObject(List<ComprehensBean> comprehensBeans){
        //随机对象
        Random random = new Random();
        int size = comprehensBeans.size();
        Set<ComprehensBean> totals = new HashSet<>();
        ArrayList<ComprehensBean> resultList = new ArrayList<>();
        //获取3个
        while (totals.size() < 3) {
            //随机再集合里取出元素，添加到新哈希集合
            totals.add((ComprehensBean)comprehensBeans.get(random.nextInt(size)));
        }
        Iterator iterator = totals.iterator();
        while (iterator.hasNext()) {
            ComprehensBean comprehensBean = (ComprehensBean) iterator.next();
            resultList.add(comprehensBean);
        }
        return resultList;
    }








}
