package zjq.demo.service.factory;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月16日下午7:20:02
 *
 **/
public class ProductFactory {

	public static Product sellProduct(String type) {
		if("food".equals(type)) {
			return new Food();
		}
		else if("cloth".equals(type)) {
			return new Cloth();
		}
		else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Product food = ProductFactory.sellProduct("food");
		food.makeMoney();
		Product cloth = ProductFactory.sellProduct("cloth");
		cloth.makeMoney();
	}
}
