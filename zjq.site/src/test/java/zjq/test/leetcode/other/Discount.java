package zjq.test.leetcode.other;
/**
 * 
 * @author zhangjq
 * @date 2019年4月25日下午1:17:14
 *
 **/
public class Discount {

	public static float discount(float money) {
		float num = money % 1;
		if(num >= 0 && num < 0.23f) {
			return money - num + 0.99f -1;
		}
		if(num >= 0.23f && num < 0.73f) {
			return money - num + 0.49f;
		}
		if(num >= 0.73f) {
			return money - num + 0.99f;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(discount(12.1f));
		System.out.println(discount(12.311f));
		System.out.println(discount(12.74f));
	}
	
}
