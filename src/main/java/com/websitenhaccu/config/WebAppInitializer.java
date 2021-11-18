package com.websitenhaccu.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		
		appContext.register(WebMvcConfig.class);
		appContext.setServletContext(servletContext);
		
//		Throw exeptiop
		DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        dispatcherServlet.setDetectAllHandlerExceptionResolvers(true);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", dispatcherServlet);

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

//		Encoding UTF-8
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		servletContext.addFilter("encodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");

//		SiteMesh 
		FilterRegistration.Dynamic sitemesh = servletContext.addFilter("sitemesh", new SiteMeshFilter());
		EnumSet<DispatcherType> sitemeshDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		sitemesh.addMappingForUrlPatterns(sitemeshDispatcherTypes, true, "/*");

	}

}
