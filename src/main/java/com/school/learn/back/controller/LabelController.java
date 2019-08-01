package com.school.learn.back.controller;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:gdf
 * @date: 2019/3/27
 * @version: 1.0
 */
@Controller
@RequestMapping("/label")
public class LabelController {

/*    @Autowired
    private LabelRepository labelRepository;*/

    /**
     * @param：map请求域的信息
     * @return:
     * @description:一级标题新增
     */
    @RequestMapping("/add")
    public void add(){
            System.out.print("I come "+"\n"+"/n");
    }
    /**
     * @param：map请求域的信息
     * @return:
     * @description:一级标题新增
     */
    //@CrossOrigin(origins = {"http://localhost:7999", "null"})
    @RequestMapping("search")
    public void search(HttpServletRequest request, HttpServletResponse response){
        /*List labels = labelRepository.findAll();
        *//*
        Iterator iterator = labels.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }*//*
        Map map = new HashMap();
        map.put("labels",labels);
        PrintWriter printWriter = null;
        try {
            //
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type", "application/json");
            printWriter = response.getWriter();
            printWriter.print(JSONObject.toJSONString(map));
            printWriter.flush();
            System.out.print("s");
        }catch (Exception e){
            //throw e;
            e.printStackTrace();
        }finally {
            printWriter.close();
        }*/
    }

}
