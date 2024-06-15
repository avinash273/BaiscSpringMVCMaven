package com.test;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("mvc", new DispatcherServlet(context));
        context.register(ApplicationConfig.class);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }

}
