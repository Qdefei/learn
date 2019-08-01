package com.school.learn.framework;

import net.minidev.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:gdf
 * @date: 2019/4/7
 * @version: 1.0
 * @description:basedao
 */

public class BaseController {
    /**
     * @param：
     * @return:
     * @description:处理映射地址
     */
    public String upLoadPath(){
        //获取项目根目录
     //return request.getSession().getServletContext().getRealPath("/");
      return "C:\\workspace\\myeclipse\\data\\";
    }
    /**
     * @param：
     * @return:
     * @description:操作成功提示
     */
    public void success(HttpServletResponse response,String string){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("success",string);
        printAll(response,map);
    }
    /**
     * @param：
     * @return:
     * @description:操作错误提示
     */
    public void error(HttpServletResponse response,String string){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("error",string);
        printAll(response,map);
    }
    /**
     * @param：
     * @return:
     * @description:单个对象输出
     */
    public void printObject(HttpServletResponse response, Map<String,Object> map){
        printAll(response,map);
    }
    /**
     * @param：
     * @return:
     * @description:日期格式化
     */
    public String dateString(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mv_date = dateFormat.format(date);
        return mv_date;
    }
    /**
     * @param：
     * @return:
     * @description:用于接收不同的参数
     */
    public void printAll(HttpServletResponse response,Map<String,Object> map){
        PrintWriter printWriter = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type", "application/json");
            printWriter = response.getWriter();
            printWriter.print(JSONObject.toJSONString(map));
            printWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            printWriter.close();
        }
    }
}
