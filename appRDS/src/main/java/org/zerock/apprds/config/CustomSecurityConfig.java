package org.zerock.apprds.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration//설정파일 
@EnableGlobalMethodSecurity(prePostEnabled = true)//보안 적용
@Log4j2//log사용
@RequiredArgsConstructor//생성자
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("-------------------configure------------------------");
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().httpStrictTransportSecurity().disable();
	}
}
