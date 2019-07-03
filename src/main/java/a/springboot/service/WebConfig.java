package a.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import a.springboot.service.util.AInterceptor;

@Component
public class WebConfig implements WebMvcConfigurer {
	
	private static final Logger log = LoggerFactory.getLogger(WebConfig.class);
	
	@Autowired
	AInterceptor aInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("[ WebConfig ] addInterceptors");
		registry.addInterceptor(aInterceptor);
	}
}
