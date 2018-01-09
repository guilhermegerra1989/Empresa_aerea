package br.com.guilherme.lemes.config;

import br.com.guilherme.lemes.core.utils.CustomNamingStrategy;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
@ComponentScan(basePackages = {"br.com.guilherme.lemes.core.*"})
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class SystemDbConfig {

    @Autowired
    private Environment env;

    @Bean
    public CustomNamingStrategy getCustomNamingStategy() {
        CustomNamingStrategy customNamingStrategy = new CustomNamingStrategy();
        customNamingStrategy.setPackageNames(new String[]{ "br.com.guilherme.lemes.core.domain.bean" });

        return customNamingStrategy;
    }

    @Bean
    public PlatformTransactionManager getSystemTransactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }

  /*  @Bean
    public DataSource dataSource() {
        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        return jndiDataSourceLookup.getDataSource("java:/jdbc/postgresql");
    }*/

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(env.getProperty("systemDb.driverClassName"));
        driverManagerDataSource.setUrl(env.getProperty("systemDb.url"));
        driverManagerDataSource.setUsername(env.getProperty("systemDb.username"));
        driverManagerDataSource.setPassword(env.getProperty("systemDb.password"));
        return driverManagerDataSource;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBuilder sessionFactoryBean = new LocalSessionFactoryBuilder(dataSource());
        sessionFactoryBean.setNamingStrategy(getCustomNamingStategy());
        sessionFactoryBean.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactoryBean.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        sessionFactoryBean.scanPackages("br.com.guilherme.lemes.core.domain.bean");

        return sessionFactoryBean.buildSessionFactory();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
