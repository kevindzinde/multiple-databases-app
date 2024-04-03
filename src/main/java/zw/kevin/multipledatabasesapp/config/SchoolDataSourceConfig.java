package zw.kevin.multipledatabasesapp.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "schoolEntityManagerFactory",
        transactionManagerRef = "schoolTransactionManager",
        basePackages = { "zw.kevin.multipledatabasesapp.schooldb.repository" }
)
public class SchoolDataSourceConfig {
    @Bean(name="schoolDataSource")
    @ConfigurationProperties(prefix="spring.schooldb.datasource")
    public DataSource schoolDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "schoolEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean schoolEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("schoolDataSource") DataSource schoolDataSource) {
        return builder
                .dataSource(schoolDataSource)
                .packages("zw.kevin.multipledatabasesapp.schooldb.entity")
                .build();
    }
    @Bean(name = "schoolTransactionManager")
    public PlatformTransactionManager schoolTransactionManager(
            @Qualifier("schoolEntityManagerFactory") EntityManagerFactory schoolEntityManagerFactory) {
        return new JpaTransactionManager(schoolEntityManagerFactory);
    }
}
