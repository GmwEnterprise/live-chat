package com.github.mrag.livechat.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.github.mrag.livechat.rest.converters.AccountStatusConverter;
import com.github.mrag.livechat.rest.converters.BloodGroupConverter;
import com.github.mrag.livechat.rest.converters.GenderConverter;
import com.github.mrag.livechat.rest.converters.LocalDateTimeConverter;
import com.github.mrag.livechat.rest.interceptor.TokenInterceptor;
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
@EnableSwagger2
@ServletComponentScan // 支持扫描Servlet组件
@ComponentScan(basePackages = "com.github.mrag.livechat.rest.controller")
public class RestAppConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(RestAppConfig.class);

    @Value("${spring.profiles.active}")
    private String profile;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.github.mrag.livechat.rest.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall-tiny")
                .contact("macro")
                .version("1.0")
                .build();
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
        // InterceptorRegister.registryInterceptors().forEach(interceptor
        //         -> registry.addInterceptor(interceptor).order(interceptor.order()));
        registry.addInterceptor(new TokenInterceptor());
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
            registry.addMapping("/**")
                    .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
        }
    }

    /**
     * 静态资源绕行
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
