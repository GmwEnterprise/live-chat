package com.github.mrag.livechat.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.github.mrag.livechat.rest.converters.AccountStatusConverter;
import com.github.mrag.livechat.rest.converters.BloodGroupConverter;
import com.github.mrag.livechat.rest.converters.GenderConverter;
import com.github.mrag.livechat.rest.converters.LocalDateTimeConverter;
import com.github.mrag.livechat.rest.interceptor.InterceptorRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Gmw
 */
@Configuration
@EnableWebMvc
@ServletComponentScan // 支持扫描Servlet组件
@ComponentScan(basePackages = "com.github.mrag.livechat.rest.controller")
public class RestAppConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(RestAppConfig.class);

    @Value("${spring.profiles.active}")
    private String profile;

    /**
     * 提供全局可使用的 JSON 转换器实例
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(f));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(f));

        mapper.registerModule(module);
        return mapper;
    }

    /**
     * 批量添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegister.registryInterceptors().forEach(interceptor
                -> registry.addInterceptor(interceptor).order(interceptor.order()));
    }

    /**
     * 添加http消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GenderConverter());
        registry.addConverter(new BloodGroupConverter());
        registry.addConverter(new AccountStatusConverter());
        registry.addConverter(new LocalDateTimeConverter());
    }

    /**
     * 跨域配置
     * TODO: 尝试使用response原生配置跨域，便于理解其原理
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if ("dev".equals(profile)) {
            registry.addMapping("/**").allowedMethods(
                    "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
        }
    }

    /**
     * 静态资源绕行
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath*:static/");
    }
}
