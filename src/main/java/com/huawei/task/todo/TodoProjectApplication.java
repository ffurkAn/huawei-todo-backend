package com.huawei.task.todo;

import com.huawei.task.todo.security.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.huawei.task.todo")
@SpringBootApplication(scanBasePackages = { "com.huawei.task.todo" })
public class TodoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoProjectApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsConfigurationSource() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new CorsFilter());
		registrationBean.addUrlPatterns("/auth/*");
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
}
