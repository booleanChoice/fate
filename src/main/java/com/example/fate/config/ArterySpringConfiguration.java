package com.example.fate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.fate.interceptor.ArteryInterceptor;

/**
 * JavaConfig显式形式装配bean
 * @author liujianzhao
 *
 */
@Configuration //该类其实就等同于xml配置中一个根节点:<beans></beans>
public class ArterySpringConfiguration {
    
    //如果不指定name,bean名称默认与方法名一样
    @Bean(name="arteryInterceptor")
    public ArteryInterceptor getArteryInterceptor() {
        /*do something*/
        return new ArteryInterceptor();//当然这里也可以用构造器来装配或者初始化bean
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }
    

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }
}
