//package com.example.springboot.config;//package com.example.springboot.config;
//
//import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
//import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.convert.support.GenericConversionService;
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean
//    public static Converter<String, MybatisProperties.CoreConfiguration> mybatisConfigurationConverter() {
//        return new Converter<String, MybatisProperties.CoreConfiguration>() {
//            @Override
//            public MybatisProperties.CoreConfiguration convert(String source) {
//                MybatisProperties.CoreConfiguration config = new MybatisProperties.CoreConfiguration();
//                // 根据需要解析字符串并设置配置属性
//                return config;
//            }
//        };
//    }
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(GenericConversionService conversionService) {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        conversionService.addConverter(mybatisConfigurationConverter());
//        return configurer;
//    }
//}
