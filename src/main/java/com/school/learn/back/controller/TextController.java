package com.school.learn.back.controller;


import org.springframework.stereotype.Controller;


@Controller
public class TextController{
   /* @Resource
    private BaseDao baseDao;

    *//*@RequestMapping("/text")
    public String text(Map<String,Object> map){
        Info info = new Info();
        info.setInfo_name("a飒飒");
        baseDao.save(info);
        //数据会默认放到请求域中
        map.put("hello","你好");
        map.put("info",info);
        //map.put("arry",new Array"H1","H2","H3"));
        return "hi";
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Info> getInfo(){
        List<Info> info = baseDao.findAll();
        return info;
    }
    @RequestMapping("/board")
    public String board(Map<String,Object> map){
        List<Info> info = baseDao.findAll();
        map.put("info",info);
        return "board";
    }*//*
    @RequestMapping("/item")
    public String item(){

        return "item";
    }
    @RequestMapping("/save")
    public String save(Info info){
        baseDao.save(info);
        System.out.print(info.getInfo_name());
        System.out.print("成功");
        return "hi";
    }*/
}
