package com.school.learn.back.controller;

import com.school.learn.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class login extends BaseController {
   /* @Autowired
    private UserRepository userRepository;
    *//**
     * @param：map请求域的信息
     * @return:
     * @description:跳转到登陆页
     *//*
    @RequestMapping("/login")
    public String login(Map<String,Object> map){
        return "login";
    }
    *//**
     * @param：map请求域的信息
     * @return:
     * @description:登陆验证
     *//*
    @RequestMapping("/index")
    public String index(Map<String,Object> map, User user) {
        if (user != null) {
            try {
                User user1 = userRepository.findByAccountAndPassword(user.getAccount(), user.getPassword());
                if (!user1.equals(null)) {
                    return "/learn/index";
                }
            }catch (Exception e){
                map.put("fail","账号或者密码错误请重新登陆");
                return "login";
            }
        }
        map.put("fail","账号或者密码错误请重新登陆");
        return "login";
    }
    *//**
     * @param：map请求域的信息
     * @return:
     * @description:用户注册
     *//*
    @PostMapping("/register")
    public void register(User user, HttpServletResponse response, Map<String,Object> map){
        userRepository.save(user);
        //success(response);
    }*/
}
