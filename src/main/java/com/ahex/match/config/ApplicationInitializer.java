package com.ahex.match.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import org.springframework.web.servlet.DispatcherServlet;



public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);
	//	rootContext.register(ApplicationConfiguration.class);// Added for activiti
		rootContext.setServletContext(container);
		rootContext.refresh();

		container.addListener(new ContextLoaderListener(rootContext));

	/*   //for security	
		
		Dynamic springSecurityFilterChain = container.addFilter("springSecurityFilterChain",
				new DelegatingFilterProxy());
		springSecurityFilterChain.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD),
				false, "/*");
		springSecurityFilterChain.setAsyncSupported(true);*/

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setAsyncSupported(true);
		
	}

}
