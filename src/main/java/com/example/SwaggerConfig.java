package com.example;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fusw
 * @version V1.0
 * @Date 2017/3/13 21:08
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
	 *
	 */

	@Bean
	public Docket userApi() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("user")
				.genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(false).pathMapping("/")
				.select().paths(or(regex("/user*")))// 过滤的接口
				.build().apiInfo(userApiInfo());
	}

	private ApiInfo userApiInfo() {

		return new ApiInfoBuilder().title("用户相关操作API")// 大标题
				.description("用户的增删查.")// 详细描述
				.version("1.0")// 版本
				.termsOfServiceUrl("NO terms of service")
				.contact(new Contact("付施威", "", "fusw@live.com"))// 作者
				.license("The Apache License, Version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build();
	}
}
