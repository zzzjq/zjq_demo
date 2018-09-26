package zjq.demo.service.adapter.interfaceAdapter;
/**
 * @author:zhangjq
 * @time:2017年10月9日 下午1:23:01
 * @version:v1.0
 */
public class Target1 extends AbstractSourceService{

	@Override
	public void say(){
		System.out.println("target1: this is what i want to say!");
	}
}
