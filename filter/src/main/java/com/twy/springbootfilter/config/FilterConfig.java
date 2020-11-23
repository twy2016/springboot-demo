package com.twy.springbootfilter.config;

import com.twy.springbootfilter.filter.MyFilter;
import com.twy.springbootfilter.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author gongpeng
 * @date 2020/8/12 11:12
 */
//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/*");
        bean.setName("myFilter");
        bean.setOrder(2);
        return bean;
    }

//    @Bean
    public FilterRegistrationBean testRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new TestFilter());
        bean.addUrlPatterns("/*");
        bean.setName("testFilter");
        bean.setOrder(1);
        return bean;
    }
}
