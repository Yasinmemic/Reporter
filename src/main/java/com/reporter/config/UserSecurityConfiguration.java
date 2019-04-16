package com.reporter.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	@Autowired
	DataSource dataSource;
	
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login.html").permitAll().antMatchers("/welcome")
            .hasAnyRole("USER", "ADMIN").antMatchers("/getUsers").hasAnyRole("USER", "ADMIN")
            .antMatchers("/addNewUser").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
            .permitAll().and().logout().permitAll();

        http.csrf().disable();
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");
        http.rememberMe().userDetailsService(userDetailsService);
    }
    
 
    @Autowired
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
    	
    	authenticationMgr.jdbcAuthentication().dataSource(dataSource);
    }
    
    

}