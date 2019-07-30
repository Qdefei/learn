package com.school.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//WebMvcConfigurerAdapter可以扩展springmvc的功能Spring内部的一种配置方式
//采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制WebMvcConfigurerAdapter常用的方法
///** 解决跨域问题 **/
//public void addCorsMappings(CorsRegistry registry) ;
///** 添加拦截器 **/
//void addInterceptors(InterceptorRegistry registry);
///** 这里配置视图解析器 **/
//void configureViewResolvers(ViewResolverRegistry registry);
///** 配置内容裁决的一些选项 **/
//void configureContentNegotiation(ContentNegotiationConfigurer configurer);
///** 视图跳转控制器 **/
//void addViewControllers(ViewControllerRegistry registry);
///** 静态资源处理 **/
//void addResourceHandlers(ResourceHandlerRegistry registry);
///** 默认静态资源处理器 **/
//void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);


//@EnableWebMvc 不要接管springMvc总的配置
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    //所有的webMvcConfiguerAdapter组件都会一起起作用
   @Bean//一定将组件注册在容器里
   public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
       WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("LoginController");
               registry.addViewController("/index.html").setViewName("LoginController");
           }
       };
       return adapter;
   }
    //文件地址url 映射

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/data/**").addResourceLocations("file:"+"C:\\workspace\\myeclipse\\data\\");
    }
               /* @Override
                public void addCorsMappings(CorsRegistry registry) {
                    // 限制了路径和域名的访问
                    *//*registry.addMapping("/api*").allowedOrigins("http://localhost:8081");*//*
                    registry.addMapping("/**")
                            .allowedOrigins(ALL)
                            .allowedMethods(ALL)
                            .allowedHeaders(ALL)
                            .allowCredentials(true);
                }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")//http://localhost:7999
                .allowedMethods("*").allowedHeaders("*")
                .allowCredentials(true)
                .exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
    }
}
