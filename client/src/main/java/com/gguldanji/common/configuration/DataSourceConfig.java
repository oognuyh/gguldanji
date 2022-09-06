package com.gguldanji.common.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySources({
  @PropertySource("classpath:application.properties"),
  @PropertySource(value = "classpath:.env", ignoreResourceNotFound = true)
})
public class DataSourceConfig {

  @Bean
  @Profile("!prod")
  public DataSource h2() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .setName("testdb;MODE=mysql")
        .generateUniqueName(false)
        .addDefaultScripts()
        .ignoreFailedDrops(false)
        .setScriptEncoding("UTF-8")
        .build();
  }

  @Bean
  @Profile("prod")
  public DataSource oracle(
      @Value("${spring.datasource.url}") String url,
      @Value("${spring.datasource.driver-class-name}") String driverClassName,
      @Value("${spring.datasource.username}") String username,
      @Value("${spring.datasource.password}") String password) {
    HikariConfig configuration = new HikariConfig();

    configuration.setJdbcUrl(url);
    configuration.setDriverClassName(driverClassName);
    configuration.setUsername(username);
    configuration.setPassword(password);
    configuration.setAutoCommit(false);

    return new HikariDataSource(configuration);
  }
}
