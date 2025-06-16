package webmvc.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebMVCInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setServletContext(servletContext);
        ServletRegistration.Dynamic frontController = servletContext.addServlet("primaryController", new DispatcherServlet(webContext));
        frontController.setLoadOnStartup(10);
        frontController.addMapping("/spring/*");
        webContext.register(SpringWebMVCConfigurator.class);
    }
}