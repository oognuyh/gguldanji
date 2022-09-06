package com.gguldanji.common.configuration;

import com.github.pagehelper.PageInterceptor;
import java.util.Properties;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@MapperScan(basePackages = "com.gguldanji.*.dao", annotationClass = Mapper.class)
public class DatabaseConfig {

  private final DataSource dataSource;

  private final ApplicationContext applicationContext;

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    PageInterceptor pageInterceptor = new PageInterceptor();
    Properties pageHelperProps = new Properties();

    sqlSessionFactoryBean.setPlugins();

    pageHelperProps.setProperty("reasonable", "true");
    pageInterceptor.setProperties(pageHelperProps);

    sqlSessionFactoryBean.setPlugins(pageInterceptor);
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setConfigLocation(
        applicationContext.getResource("classpath:mybatis-config.xml"));
    sqlSessionFactoryBean.setTypeAliasesPackage("com.gguldanji.*.entity");
    sqlSessionFactoryBean.setTypeHandlersPackage("com.gguldanji.common.typehandler");
    // sqlSessionFactoryBean.setMapperLocations(
    //     applicationContext.getResources("classpath:mapper/*.xml"));

    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate() throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory());
  }
}
