package kovalalex.movies.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(basePackages = "kovalalex.movies.repository")
public class PersistenceConfig {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "spring.datasource.driverClassName";
    private static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";

    @Autowired
    private Environment env;

    public PersistenceConfig() {
        super();
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env
                .getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env
                .getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env
                .getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env
                .getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("kovalalex.movies.domain");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties additionalProperties() {

        final Properties hibernateProperties = new Properties();
       hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
//        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        hibernateProperties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return hibernateProperties;
    }

}
