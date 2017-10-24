package com.xiao.ex.common;

import com.xiao.ex.utils.DbUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 说明:   Druid配置
 *
 * @author xiaoting
 *         Created by 2017-03-23 14:40
 **/
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = DruidDataSourceConfiguration.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class DruidDataSourceConfiguration extends DataSourceCom {

    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class);
    static final String PACKAGE = "com.xiao.ex.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;


    @Bean    //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        if (dbUrl.contains("{ip}")) {
            dbUrl= dbUrl.replace("{ip}", DbUtil.dbUrl);
        }
        if (username.contains("{user}")) {
            username= username.replace("{user}", DbUtil.userName);
        }
        if (password.contains("{pwd}")) {
            password= password.replace("{pwd}", DbUtil.pwd);
        }
        System.out.println("------" + password + username + dbUrl);
        return getDataSource(dbUrl, username, password, driverClassName);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DruidDataSourceConfiguration.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}

