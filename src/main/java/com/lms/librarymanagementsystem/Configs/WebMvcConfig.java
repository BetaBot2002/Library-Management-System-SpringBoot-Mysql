package com.lms.librarymanagementsystem.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lms.librarymanagementsystem.Interceptors.AdminInterceptor;
import com.lms.librarymanagementsystem.Interceptors.LoginInterceptor;
import com.lms.librarymanagementsystem.Interceptors.SessionInterceptor;
import com.lms.librarymanagementsystem.Interceptors.UserInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private LoginInterceptor loginInterceptor;
    private AdminInterceptor adminInterceptor;
    private UserInterceptor userInterceptor;
    private SessionInterceptor sessionInterceptor;

    public WebMvcConfig(LoginInterceptor loginInterceptor,AdminInterceptor adminInterceptor,UserInterceptor userInterceptor,SessionInterceptor sessionInterceptor) {
        this.loginInterceptor = loginInterceptor;
        this.adminInterceptor = adminInterceptor;
        this.userInterceptor = userInterceptor;
        this.sessionInterceptor = sessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
        .addPathPatterns("/**").excludePathPatterns("/login/**","/registration/**","/img/**","/css/**","/js/**","/donation/**","/error/**");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/login/**","/registration/**");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**");
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/user/**");

    }
}
