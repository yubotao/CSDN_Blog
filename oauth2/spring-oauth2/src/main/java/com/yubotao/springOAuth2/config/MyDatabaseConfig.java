package com.yubotao.springOAuth2.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author:
 * @Date:
 * @Description: 数据库配置
 */
@Configuration
@EnableJpaRepositories("com.yubotao.springOAuth2")
public class MyDatabaseConfig {

    @Value("${db.driver}")
    private String DB_DRIVER;

    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.username}")
    private String DB_USERNAME;

    @Value("${db.password}")
    private String DB_PASSWORD;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${entitymanager.packagesToScan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN;

//    @Value("${hibernate.query.plan_cache_max_size}")
//    private String HIBERNATE_QUERY_PLAN_CACHE_MAX_SIZE;
//
//    @Value("${hibernate.query.plan_parameter_metadata_max_size}")
//    private String HIBERNATE_QUERY_PLAN_PARAMETER_METADATA_MAX_SIZE;

//    @Value("${hibernate.cache.use_second_level_cache}")
//    private String HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
//
//    @Value("${hibernate.cache.use_query_cache}")
//    private String HIBERNATE_CACHE_USE_QUERY_CACHE;
//
//    @Value("${hibernate.cache.provider_class}")
//    private String HIBERNATE_CACHE_PROVIDER_CLASS;
//
//    @Value("${hibernate.cache.region.factory_class}")
//    private String HIBERNATE_CACHE_REGION_FACTORY_CLASS;

    Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
        properties.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        properties.setProperty("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName(DB_DRIVER);
        dds.setUrl(DB_URL);
        dds.setUsername(DB_USERNAME);
        dds.setPassword(DB_PASSWORD);

        //配置初始化大小、最小、最大
        dds.setMaxActive(200);
        dds.setInitialSize(1);
        dds.setMinIdle(1);

        //配置获取连接等待超时的时间  单位毫秒
        dds.setMaxWait(20000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dds.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        dds.setMinEvictableIdleTimeMillis(300000);

        dds.setValidationQuery("SELECT 'x'");
        dds.setTestWhileIdle(true);
        dds.setTestOnReturn(false);
        dds.setTestOnBorrow(false);

        //打开PSCache，并且指定每个连接上PSCache的大小
        dds.setPoolPreparedStatements(false);
        //dds.setMaxPoolPreparedStatementPerConnectionSize(20);

        //配置监控统计拦截的filters
        try {
            dds.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //打开removeAbandoned功能
        dds.setRemoveAbandoned(true);
        // 1800秒，也就是30分钟
        dds.setRemoveAbandonedTimeout(1800);
        dds.setLogAbandoned(true);
        return dds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(jpaProperties());
        em.setPersistenceUnitName("customers");
        return em;
    }

//    @Bean
//    @Primary
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(this.dataSource());
//        sessionFactoryBean.setPackagesToScan(new String[]{this.ENTITYMANAGER_PACKAGES_TO_SCAN});
//        sessionFactoryBean.setHibernateProperties(jpaProperties());
//        return sessionFactoryBean;
//    }
//
//    @Bean(name = "customerTransactionManager")
//    @Primary
//    public JpaTransactionManager transactionManager(EntityManagerFactory customerEntityManager) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(customerEntityManager);
//        return transactionManager;
//    }
}
