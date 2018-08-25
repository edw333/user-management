package ro.edw333.usermanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}

	@Override
	public void configure(final HttpSecurity httpSecurity) throws Exception{
		httpSecurity
				.authorizeRequests()
				.antMatchers("/**").hasRole("ADMIN")
				.and()
				.formLogin()
//					.loginPage("/login")
					.defaultSuccessUrl("/**").permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.deleteCookies("JSESSIONID").invalidateHttpSession(true)
				.logoutSuccessUrl("/login")
				.permitAll();
	}
}
