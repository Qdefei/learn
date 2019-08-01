package com.school.learn.back.controller;

import com.school.learn.back.entity.MvCountry;
import com.school.learn.back.repository.MvCountryRepository;
import com.school.learn.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:gdf
 * @date: 2019/8/1
 * @version: 1.0
 * @decription:国家类别模块
 */
@Controller
@RequestMapping("/country")
public class MvCountryController extends BaseController{
    @Autowired
    private MvCountryRepository mvCountryRepository;
    /**
     * @param:标题名
     * @return:
     * @description:查询国家类别信息
     */
    @RequestMapping(value = "/query")
    public void query(String sname,HttpServletResponse response){
        if (sname.trim()=="" || sname==null){
            List<MvCountry> list = mvCountryRepository.findAll();
            Map<String,Object> map = new HashMap<>();
            map.put("items",list);
            printObject(response,map);
        }else {
            List<MvCountry> list = mvCountryRepository.findBySnameLike(sname);
            Map<String,Object> map = new HashMap<>();
            map.put("items",list);
            printObject(response,map);
        }
    }
    /**
     * @param:标题名
     * @return:
     * @description:新增国家类别信息
     */
    @RequestMapping(value="/save")
    public void save(@RequestBody MvCountry mvCountry, HttpServletResponse response){
        if(mvCountryRepository.findBySid(mvCountry.getSid())!=null){
            error(response,"类别重复请重新输入");
            return;
        }else {
            mvCountry.setSlastupdate(dateString());
            mvCountryRepository.save(mvCountry);
            success(response,"保存成功");
        }
    }

    /**
     * @param:标题名
     * @return:
     * @description:修改国家类别信息
     */
    @RequestMapping(value="/update")
    public void update(@RequestBody MvCountry mvCountry,HttpServletResponse response){
        try {
            String sid = mvCountry.getSid();
            String name = mvCountry.getSname();
            String mv =mvCountry.getSmv();
            String desc = mvCountry.getSdesc();
            String expired = mvCountry.getSexpired();
            String lastupdate = dateString();
            String lastupdateby = mvCountry.getSlastupdateby();
            mvCountryRepository.update(sid,name,desc,mv,expired,lastupdate,lastupdateby);
            success(response,"修改成功");
        }catch (Exception exception){
            error(response,"修改失败");
            exception.printStackTrace();
        }
    }
    /**
     * @param:标题名
     * @return:
     * @description:复制国家类别信息
     */
    @RequestMapping("/copy")
    public void copy(@RequestBody MvCountry mvCountry,HttpServletResponse response){
        mvCountry.setSlastupdate(dateString());
        if(mvCountryRepository.findBySid(mvCountry.getSid())!=null){
            error(response,"复制类别重复请重新输入");
            return;
        }else {
            mvCountry.setSlastupdate(dateString());
            mvCountryRepository.save(mvCountry);
            success(response,"保存成功");
        }
    }
    /**
     * @param:标题名
     * @return:
     * @description:删除国家类别信息
     */
    @RequestMapping("/remove")
    public void  remove(String sid,HttpServletResponse response){
        mvCountryRepository.deleteById(sid);
        success(response,"删除成功");
    }
    
}
