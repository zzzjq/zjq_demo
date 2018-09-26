//package zjq.demo.common;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
///**
// * Servlet3.0代替Web.xml
// * @author:zhangjq
// * @time:2017年5月5日 下午2:09:19
// * @version:v1.0
// */
//public class WebInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext arg0) throws ServletException {
//		AnnotationConfigWebApplicationContext ctx = 
//				new AnnotationConfigWebApplicationContext();
//		ctx.register(MyMvcConfig.class);
//		ctx.setServletContext(arg0);
//
//		Dynamic servlet = arg0.addServlet("dispatcher", 
//				new DispatcherServlet(ctx));
//		servlet.addMapping("/");
//		servlet.setLoadOnStartup(1);
//
//	}
//
//}
