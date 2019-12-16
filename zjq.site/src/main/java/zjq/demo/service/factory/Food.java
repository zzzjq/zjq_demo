package zjq.demo.service.factory;
/**
 * 
 * @author zhangjingqi
 * @date 2019年12月16日下午7:18:56
 *
 **/
public class Food implements Product{

	@Override
	public void makeMoney() {
		System.out.println("Food make Money");
	}

}
