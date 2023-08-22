package com.xyx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :xyx
 * @date :2021/5/9 11:25
 * @description:网络跨域处理
 * @
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("*")
//                SpringBoot升级2.4.0之后，跨域配置中的.allowedOrigins不再可用
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
//        registry.addInterceptor(checkTokenInterceptor)
//                .addPathPatterns("/shopcart/**")
//                .addPathPatterns("/orders/**")
//                .addPathPatterns("/useraddr/**")
//                .addPathPatterns("/user/check");
    }
}
