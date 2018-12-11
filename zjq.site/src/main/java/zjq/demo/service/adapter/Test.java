package zjq.demo.service.adapter;
/**
 * 适配器模式
 * 
 * @author:zhangjq
 * @time:2017年10月9日 下午1:12:28
 * @version:v1.0
 */
public class Test {

	public static void main(String args[]){
		//类的适配器模式,通过继承来实现
		//核心思想就是：有一个Source类，拥有一个方法，待适配
		//目标接口时Target，通过Adapter类，将Source的功能扩展到Target里
		Target target = new Adapter();
		target.say();
		target.doo();
		
		//对象的适配器模式，将需要适配的实例作为适配器的成员
		//只是将Adapter类作修改，这次不继承Source类，
		//而是持有Source类的实例，以达到解决兼容性的问题
		Target target2 = new ClassAdapter(new Source());
		target2.say();
		target2.doo();
	}
}
