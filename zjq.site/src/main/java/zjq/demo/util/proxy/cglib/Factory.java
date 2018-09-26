package zjq.demo.util.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author:zhangjq
 * @time:2017年8月30日 上午11:53:57
 * @version:v1.0
 */
public class Factory {

	public static Service getInstance(CglibProxy cglibProxy){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Service.class);
		enhancer.setCallback(cglibProxy);
		Service service = (Service) enhancer.create();
		return service;
	}
}
