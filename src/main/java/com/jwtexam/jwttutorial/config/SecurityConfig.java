package com.jwtexam.jwttutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
// 기본적인 Web 보안을 활성화 하겠다는 의미의 어노테이션
// 추가적인 설정을 위해 WebSecurityConfigure 를 implement 하거나,
// WebSecurityConfigureAdapter 를 extends 하는 방법이 있다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // HttpServletRequest 를 사용하는 요청들에 대한 접근제한을 설정하겠다는 의미
                .authorizeRequests()
                // 해당 API 에 대한 요청은 인증없이 접근을 허용하겠다는 의미
                .antMatchers("/api/hello").permitAll()
                // 나머지 요청들은 모두 인증되어야 한다는 의미
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**"
                        , "/favicon.ico"
                );
    }
}
