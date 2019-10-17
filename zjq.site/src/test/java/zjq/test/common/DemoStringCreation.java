package zjq.test.common;

/**
 * string test
 * 
 * @author:zhangjq
 * @time:2017年10月10日 下午3:33:06
 * @version:v1.0
 */
public class DemoStringCreation {
	
	public static void main(String args[]) {
//		String str1 = "Hello";
//		String str2 = "Hello";
//		System.out.println("str1 and str2 are created by using string literal.");
//		System.out.println("    str1 == str2 is " + (str1 == str2));
//		System.out.println("    str1.equals(str2) is " + str1.equals(str2));
//		String str3 = new String("Hello");
//		String str4 = new String("Hello");
//		System.out.println("str3 and str4 are created by using new operator.");
//		System.out.println("    str3 == str4 is " + (str3 == str4));
//		System.out.println("    str3.equals(str4) is " + str3.equals(str4));
//		String str5 = "Hel" + "lo";
//		String str6 = "He" + "llo";
//		System.out.println("str5 and str6 are created by using string constant expression.");
//		System.out.println("    str5 == str6 is " + (str5 == str6));
//		System.out.println("    str5.equals(str6) is " + str5.equals(str6));
//		String s = "lo";
//		String str7 = "Hel" + s;
//		String str8 = "He" + "llo";
//		System.out.println("str7 is computed at runtime.");
//		System.out.println("str8 is created by using string constant expression.");
//		System.out.println("    str7 == str8 is " + (str7 == str8));
//		System.out.println("    str7.equals(str8) is " + str7.equals(str8));

		//jdk1.6和jdk1.7不一样，1.7以后如果先intern，则会把堆里的引用复制到常量池里面，则s3==s1 true
		// String的intern()方法会查找在常量池中是否存在一份equal相等的字符串,
		// 如果有则返回该字符串的引用,
		// 如果没有则添加自己的字符串进入常量池。
		//String s2 = new String("计算机");
		String s3 = new String("计") + new String("算机");
		//s2.intern();
		s3.intern();
		String s1 = "计算机";
		//System.out.println("s1 == s2? " + (s1 == s2));
		System.out.println("s1 == s3? " + (s1 == s3));
		//System.out.println("s2 == s3? " + (s2 == s3));
		
		/** 翻转字符串 **/
//		String a = "abcdefg";
//		StringBuffer sb = new StringBuffer(a);
//		System.out.println(sb.reverse().toString());

	}

}
