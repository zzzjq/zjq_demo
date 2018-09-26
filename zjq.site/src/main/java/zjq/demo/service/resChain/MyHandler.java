package zjq.demo.service.resChain;
/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:16:47
 * @version:v1.0
 */
public class MyHandler extends AbstractHandler implements Handle{

	private String name;
	
	public MyHandler(String name){
		this.name = name;
	}
	
	@Override
	public void operator() {
		// TODO Auto-generated method stub
		System.out.println(name + "deal!");
		if(getHandle() != null)
			getHandle().operator();
	}

}
