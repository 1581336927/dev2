package com.hcy.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

//扫描加载配置文件
@PropertySource("classpath:jdbc.properties")
//指定包扫描路径，会扫面指定包下的所有注解
@ComponentScan("com.hcy")
//当前类是一个配置类
@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //用于将指定方法的返回值作为容器的对象
    @Bean
    public JdbcTemplate jdbcTemplate() {


        JdbcTemplate jdbcTemplate = null;
        Properties properties = new Properties();

        properties.setProperty("driverClassName", driverClassName);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        DataSource source;
        try {
            source = DruidDataSourceFactory.createDataSource(properties);

            jdbcTemplate=new JdbcTemplate(source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jdbcTemplate;
    }
}
