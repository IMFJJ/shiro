package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.util.ExcelUnit;
import com.study.util.HttpClientUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqj on 2017/4/22.
 */
@RestController
@RequestMapping("/py")
public class PyController {

    @RequestMapping(value = "/find")
    @ResponseBody
    public String find(Integer page) {
        if(page==null){
            return "请输入正确的参数";
        }
        return getList(page).toString();
    }

    private List<JSONObject> getList(Integer size)  {
        int page= (int)Math.ceil(size/100.0);
        System.out.print(page);
        int i=0;
        List<JSONObject> jsonObjectAll=new ArrayList<>();
        while (page>i){
            String post= HttpClientUtil.sendPost("http://www.gzaic.gov.cn/gzaic/Jyycml/PageJson.html","query.sptype=001&page.pageNo="+i+"&page.pageSize="+100);
            JSONObject jsonObject=JSON.parseObject(post);
            List<JSONObject> jsonObjectTemp= (List<JSONObject>) jsonObject.get("rows");
            jsonObjectAll.addAll(jsonObjectTemp);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        ExcelUnit.writeXlsx(jsonObjectAll);
        return  jsonObjectAll;
    }

  /*  public  static  void  main(String args []){
        PyController pyController=new PyController();
        pyController.getList(100);
    }*/
}
