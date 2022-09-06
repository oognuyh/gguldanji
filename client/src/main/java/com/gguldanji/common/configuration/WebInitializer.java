package com.gguldanji.common.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {ServletConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);

    ServletRegistration.Dynamic h2Console =
        servletContext.addServlet("h2-console", new WebServlet());
    h2Console.setLoadOnStartup(2);
    h2Console.addMapping("/h2-console/*");
  }
}
