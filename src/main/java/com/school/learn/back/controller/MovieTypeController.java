package com.school.learn.back.controller;

import com.school.learn.back.entity.MvTypes;
import com.school.learn.back.repository.ImageRepository;
import com.school.learn.back.repository.MvTypesRepository;
import com.school.learn.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author:gdf
 * @date: 2019/3/20
 * @version: 1.0
 * @decription:视频类别模块
 */
@Controller
@RequestMapping("/type")
public class MovieTypeController extends BaseController{
    @Autowired
    private MvTypesRepository mvTypesRepository;
    @Autowired
    private ImageRepository imageRepository;

    /**
     * @param:标题名
     * @return:
     * @description:查询视频类别信息
     */
    @RequestMapping(value = "/query")
    public void query(String sid,HttpServletResponse response){
            if (sid.trim()=="" || sid.trim()==null){
                List<MvTypes> list = mvTypesRepository.findAll();
                Map<String,Object> map = new HashMap<>();
                map.put("items",list);
                printObject(response,map);
            }else {
                MvTypes ob = mvTypesRepository.queryMv(sid);
                List<Object> list = new ArrayList<>();
                list.add(ob);
                Map<String,Object> map = new HashMap<>();
                map.put("items",list);
                printObject(response,map);
            }
    }
    /**
     * @param:标题名
     * @return:
     * @description:新增视频类别信息
     */
    @RequestMapping(value="/save")
    public void save(@RequestBody MvTypes mvTypes,HttpServletResponse response){
            if(mvTypesRepository.findBySid(mvTypes.getSid())!=null){
                error(response,"类别重复请重新输入");
                return;
            }else {
                mvTypes.setSlastupdate(dateString());
                mvTypesRepository.save(mvTypes);
                success(response,"保存成功");
            }
    }
    /**
     * @param:标题名
     * @return:
     * @description:修改视频类别信息
     */
    @RequestMapping(value="/update")
    public void update(@RequestBody MvTypes mvTypes,HttpServletResponse response){
        try {
            String sid = mvTypes.getSid();
            String name = mvTypes.getSname();
            String desc = mvTypes.getSdesc();
            String expired = mvTypes.getSexpired();
            String lastupdate = dateString();
            String lastupdateby = mvTypes.getSlastupdateby();
            mvTypesRepository.update(sid,name,desc,expired,lastupdate,lastupdateby);
            success(response,"修改成功");
        }catch (Exception exception){
            error(response,"修改失败");
            exception.printStackTrace();
        }
    }
    /**
     * @param:标题名
     * @return:
     * @description:复制视频类别信息
     */
    @RequestMapping("/copy")
    public void copy(@RequestBody MvTypes mvTypes,HttpServletResponse response){
        mvTypes.setSlastupdate(dateString());
        if(mvTypesRepository.findBySid(mvTypes.getSid())!=null){
            error(response,"复制类别重复请重新输入");
            return;
        }else {
            mvTypes.setSlastupdate(dateString());
            mvTypesRepository.save(mvTypes);
            success(response,"保存成功");
        }
    }
    /**
     * @param:标题名
     * @return:
     * @description:删除视频类别信息
     */
    @RequestMapping("/remove")
    public void  remove(String sid,HttpServletResponse response){
        mvTypesRepository.deleteById(sid);
        success(response,"删除成功");
    }
}
