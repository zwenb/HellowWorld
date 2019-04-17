package com.zwb;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * 启动springboot
 *
 *  extends WebMvcConfigurerAdapter
 *
 * @author zhangwenbo
 * @create 2018/5/22
 **/
@SpringBootApplication
//将项目中对应的mapper类的路径加进来就可以了
@MapperScan("com.zwb.mapper")
@EnableElasticsearchRepositories(basePackages = "com.zwb.dao")
@EnableSwagger2
public class App{

	//json解析
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1、需要先定义一个 convert 转换消息的对象;
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3、在convert中添加配置信息.
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}


    public static void main(String[] args) throws Exception {

        SpringApplication.run(App.class, args);
    }

}
