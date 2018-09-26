package zjq.test.common;
/**
 * @author:zhangjq
 * @time:2018年2月27日 上午10:53:58
 * @version:v1.0
 */
public class Inner {
	
	//所有都能访问，static可以直接访问
	public static String str1 = "str1";
	
	//只有自己类中能访问，static可以直接访问
	private static String str2 = "str2";
	
	//所有都能访问，需要实例
	public String str3 = "str3";
	
	//只有自己类中能访问,需要实例
	private String str4 = "str4";
	
	static{
		System.out.println("外部类static块加载");
	}
	
	public Inner(){
		System.out.println("外部类构造");
	}
	
	public static class Inner1{
		public static String s1 = "111";
		
		public Inner1() {
			System.out.println("内部类Inner1构造");
		}
		static{
			System.out.println("内部类Inner1加载");
		}
	}
	
	public class Inner2{
		private String s2 = "222";
		
		public Inner2() {
			System.out.println("内部类Inner2构造");
		}
	}
	
	public static void main(String[] args){
		Inner i = new Inner();
		Inner2 i2 = i.new Inner2();
		System.out.println(i2.s2);
		System.out.println(Inner1.s1);
	}
}
