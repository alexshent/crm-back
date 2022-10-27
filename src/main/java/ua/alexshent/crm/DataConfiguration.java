package ua.alexshent.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

// https://www.digitalocean.com/community/tutorials/spring-data-jpa

@Configuration
@PropertySource("classpath:database.properties")
@EnableJpaRepositories("ua.alexshent.crm.repository")
@EnableTransactionManagement
public class DataConfiguration {

    @Autowired
    Environment environment;

    @Bean
    DataSource dataSource() {
        final String PROPERTY_DRIVER = "db.driver";
        final String PROPERTY_URL = "db.url";
        final String PROPERTY_USERNAME = "db.user";
        final String PROPERTY_PASSWORD = "db.password";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty(PROPERTY_URL));
        dataSource.setUsername(environment.getProperty(PROPERTY_USERNAME));
        dataSource.setPassword(environment.getProperty(PROPERTY_PASSWORD));
        dataSource.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
        return dataSource;
    }

    Properties hibernateProps() {
        final String propertyShowSql = "hibernate.show_sql";
        final String propertyDialect = "hibernate.dialect";
        final String propertyFormat = "hibernate.format_sql";
        final String propertyDdlAuto = "hibernate.hbm2ddl.auto";

        Properties properties = new Properties();
        properties.setProperty(propertyDialect, environment.getProperty(propertyDialect));
        properties.setProperty(propertyShowSql, environment.getProperty(propertyShowSql));
        properties.setProperty(propertyFormat, environment.getProperty(propertyFormat));
        properties.setProperty(propertyDdlAuto, environment.getProperty(propertyDdlAuto));
        return properties;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean fb = new LocalContainerEntityManagerFactoryBean();
        fb.setDataSource(this.dataSource());
        fb.setJpaProperties(this.hibernateProps());
        fb.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
        fb.setPackagesToScan("ua.alexshent.crm.model");
        return fb;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return transactionManager;
    }
}
