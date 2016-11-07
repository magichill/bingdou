package com.bingdou;


import com.bingdou.api.config.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.boot.builder.SpringApplicationBuilder;
////import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
////import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by gaoshan on 16-10-20.
 * @SpringBootApplication 相当于使用了(@Configuration, @EnableAutoConfiguration and @ComponentScan)的默认设置
 */

@SpringBootApplication
public class App {

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/v1/data/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

