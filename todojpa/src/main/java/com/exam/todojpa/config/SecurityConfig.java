package com.exam.todojpa.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService customUserDetailsService;  //사용자가 이 인터페이스를 구현하는 객체 생성해줘야함.. 
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder 생성
    }
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        //어떤 UserDetailsService를 사용하고, 어떤 PasswordEncoder를 사용하는지
	        auth.userDetailsService(customUserDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	 
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	    	web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**", "/**/*.html", "/**/*.css", "/**/*.js");
	    }
	 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        		 .antMatchers("/").permitAll()
	        		.antMatchers("/addUser").permitAll()
	                .antMatchers("/api/**").hasRole("USER")
	                .antMatchers("/todo.html").hasRole("USER") // ignoring되어 있어서 권한이 없어도 접근된다. 이경운 html에서특정 api를 호출한 후 403 오류가 발생하면redirect하도록 한다.
	                .antMatchers("/admin/api/**").hasRole("ADMIN")
	                .anyRequest().authenticated()
	                .and().formLogin().loginPage("/loginform.html")
	                .passwordParameter("password")
	                .usernameParameter("email")
	                .loginProcessingUrl("/login")
	                .failureUrl("/userregform.html")
//	                .successHandler(new CustomneAuthenticationSuccessHandler())
	                .permitAll()
	                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/userregform.html").permitAll()
//	                .and().exceptionHandling().authenticationEntryPoint(new AlwaysSendUnauthorized401AuthenticationEntryPoint())
	                .and().csrf().disable();
	    }
	 
	 class AlwaysSendUnauthorized401AuthenticationEntryPoint implements AuthenticationEntryPoint {
	        @Override
	        public final void commence(HttpServletRequest request, HttpServletResponse response,
	                                   AuthenticationException authException) throws IOException {
	        	System.out.println("error");
	        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	        }
	    }
	    
	    class CustomneAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				response.sendRedirect("/todojpa/");
			}
		}
}
