package zjq.demo.service.adapter.interfaceAdapter;
/**
 * @author:zhangjq
 * @time:2017年10月9日 下午1:25:29
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args){
		SourceInterface interface1 = new Target1();
		SourceInterface interface2 = new Target2();
		
		interface1.say();
		interface1.doo();
		interface2.say();
		interface2.doo();
	}
}
