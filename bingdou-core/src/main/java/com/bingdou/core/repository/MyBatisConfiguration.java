package com.bingdou.core.repository;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by gaoshan on 16-10-26.
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.bingdou.core.mapper")
public class MyBatisConfiguration {

        @Bean
        public DataSource dataSource() {
            return DataSourceBuilder.create(Thread.currentThread().getContextClassLoader())
                    .driverClassName("com.mysql.jdbc.Driver")
                    .url("jdbc:mysql://localhost:3306?useUnicode=true&amp;characterEncoding=utf-8")
                    .username("root")
                    .password("root").build();
        }

        @Bean
        public PlatformTransactionManager txManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource());

            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

            sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
            sqlSessionFactoryBean.setMapperLocations(resolver
                    .getResources("classpath*:/maps/**/*.xml"));
            return sqlSessionFactoryBean.getObject();
        }

    }
