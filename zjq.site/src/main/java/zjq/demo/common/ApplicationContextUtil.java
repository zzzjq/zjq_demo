package zjq.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:zhangjq
 * @time:2016年11月25日 下午3:52:01
 * @version:v1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware{
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextUtil.class);
	
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		
		logger.info("系统启动");
		ApplicationContextUtil.applicationContext = applicationContext;
	}

	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}

}
