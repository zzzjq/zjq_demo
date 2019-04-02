package zjq.test.common;

/**
 * String作为参数传的时候，str = new String("success")原值不变 ； 
 * 数组作为参数时，改变数组的值，原值也变了；
 * 基本类型作为参数传的时候，原值不变；
 * 数组里面的某一个作为参数时，传进去，则原数组不会变；
 * 
 * @author zhangjq
 * @date 2019年4月2日下午7:28:59
 *
 **/
public class PassParameterTest {

	private static void change(String str, char[] chars, int i, char ch) {
		System.out.println("改变后的值");
		str = "success";
		System.out.println(str);
		chars[2] = '二';
		System.out.println(chars);
		i = 2;
		System.out.println(i);
		ch = '五';
		System.out.println(ch);
	}

	public static void main(String[] args) {
		String str = "original";
		char[] chars = { '星', '期', '一' };
		int i = 1;
		char[] ch = { '星', '期', '三' };
		change(str, chars, i, ch[2]);
		System.out.println("原值:");
		System.out.println(str);
		System.out.println(chars);
		System.out.println(i);
		System.out.println(ch);
	}
}
