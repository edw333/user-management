package ro.edw333.usermanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/api/**").setViewName("index.html");
		registry.addViewController("/login").setViewName("login");
	}

}
