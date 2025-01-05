package com.example.schedule.domain.common;

import com.example.schedule.domain.common.filter.ExceptionCheckFilter;
import com.example.schedule.domain.common.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Config: 설정값(전체적인 흐름에 대한 설정)
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // login 필터를 빈에 등록(= 스프링부트에게 알려준다)
    @Bean
    public FilterRegistrationBean<Filter> loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

    // ExceptionCheckFilter 빈에 등록 (todo 이 부분 아직 안고침)
    @Bean
    FilterRegistrationBean<Filter> addFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new ExceptionCheckFilter());
        filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
        filterFilterRegistrationBean.addUrlPatterns("/*");
        return filterFilterRegistrationBean;
    }
}
