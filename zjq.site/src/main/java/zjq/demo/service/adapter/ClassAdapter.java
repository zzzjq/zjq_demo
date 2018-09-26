package zjq.demo.service.adapter;
/**
 * @author:zhangjq
 * @time:2017年10月9日 下午1:15:04
 * @version:v1.0
 */
public class ClassAdapter implements Target{

	private Source source;
	
	public ClassAdapter(Source source){
		this.source = source;
	}

	@Override
	public void say() {
		source.say();
	}

	@Override
	public void doo() {
		System.out.println("this is what i want to do!");
	}
	
}
