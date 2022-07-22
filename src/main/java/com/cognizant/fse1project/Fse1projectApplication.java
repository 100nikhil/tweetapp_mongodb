package com.cognizant.fse1project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class Fse1projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fse1projectApplication.class, args);
	}
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
//	@Bean
//	public Docket swaggerConfiguration() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.cognizant.fse1project")).build().apiInfo(apiDetails());
//	}
//
//	private ApiInfo apiDetails() {
//		return new ApiInfo("Tweet app API", "Final API for Tweet App", "1.0.0", "Free to use",
//				new springfox.documentation.service.Contact("Nikhil Choudhary", "pod2.com", "nikhil.choudhary2@cognizant.com"),
//				"API License", "Welcome to Tweet app API", Collections.emptyList());
//	}

}
