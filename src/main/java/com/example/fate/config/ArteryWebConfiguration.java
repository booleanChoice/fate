package com.example.fate.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.example.fate.formatter.USLocalDateFormatter;

@Configuration
public class ArteryWebConfiguration extends WebMvcConfigurerAdapter {
    
    @Autowired
    private HandlerInterceptor arteryInterceptor;
    
    @Autowired
    private LocaleChangeInterceptor localeChangeInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }
    
    /**
     * 增加一些资源管理器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/artery/**").addResourceLocations("classpath:/artery/");
    }
    
    
    /**
     * addInterceptor构造了一个拦截器链,只有经过DispatcherServlet 的请求，才会走拦截器链
     * @return
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(arteryInterceptor);
    }
}
