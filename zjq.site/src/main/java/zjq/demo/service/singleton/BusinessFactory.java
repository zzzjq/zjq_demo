package zjq.demo.service.singleton;
/**
 * 静态内部类 保持单例
 * @author:zhangjq
 * @time:2017年5月25日 下午1:32:38
 * @version:v1.0
 */
public class BusinessFactory {
	
	private BusinessFactory(){}
	
	private static class InnerFactory{
		private static final BusinessFactory businessFactory = new BusinessFactory();
	}
	
	public static BusinessFactory getBusinessFactory(){
		return InnerFactory.businessFactory;
	}
}
