package com.github.mrag.livechat.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.github.mrag.livechat.rest.interceptor.InterceptorRegister;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Gmw
 */
@Configuration
@EnableWebMvc
@ServletComponentScan // 支持扫描Servlet组件
@EnableSwagger2 // 启动Swagger2
public class RestAppConfig implements WebMvcConfigurer {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("LiveChatApp")
                .description("即时通讯App后台服务")
                .version("v1")
                .build();
    }

    /**
     * 提供Swagger2所需实例
     */
    @Bean
    public Docket createApiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .groupName("LiveChatGroup")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.mrag.livechat.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

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

    /**
     * 跨域配置
     * TODO: 尝试使用response原生配置跨域，便于理解其原理
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
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
