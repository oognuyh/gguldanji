package com.gguldanji.common.configuration;

import com.gguldanji.user.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDao userDao;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic()
        .disable()
        .csrf()
        .disable()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .and()
        .logout()
        .logoutSuccessUrl("/login");

    http.authorizeRequests().anyRequest().permitAll();

    http.addFilterBefore(new CharacterEncodingFilter("utf-8", true), CsrfFilter.class);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(
            (email) -> userDao.findUserByEmail(email).orElseThrow(RuntimeException::new))
        .passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/h2-console/**", "/resources/**", "/webjars/**");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
