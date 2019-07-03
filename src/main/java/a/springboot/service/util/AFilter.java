package a.springboot.service.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(AFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("[ AFilter ] Remote Host " + request.getRemoteHost());
		log.info("[ AFilter ] Remote Address " + request.getRemoteAddr());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("[ AFilter ] init " + filterConfig);
	}
	
	@Override
	public void destroy() 	{
		log.info("[ AFilter ] destroy");
	}
}
