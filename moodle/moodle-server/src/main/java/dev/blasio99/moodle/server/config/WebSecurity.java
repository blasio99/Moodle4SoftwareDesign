package dev.blasio99.moodle.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {


	@Autowired
 	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
			.and ()
			.csrf().disable()
            .authorizeRequests()
			//.antMatchers("/**").permitAll()
			.antMatchers("/login").permitAll()
            .antMatchers("/api/**").hasAnyRole(String.valueOf("STUDENT"), String.valueOf("TEACHER"))
            .antMatchers("/teacher/api/**").hasRole(String.valueOf("TEACHER"))
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
}
