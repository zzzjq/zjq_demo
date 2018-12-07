package zjq.test.common;

/**
 * @author:zhangjq
 * @time:2017年7月11日 下午3:28:07
 * @version:v1.0
 */
public class EncodingTest {

	public static void main(String[] args) throws Exception{
//		System.out.println("你".getBytes("UTF-8").length);
//		System.out.println("你".getBytes("UTF-16").length);
//		System.out.println("你".getBytes("UTF-32").length);
//		System.out.println("你".getBytes("GBK").length);
//		System.out.println("你".getBytes("GB2312").length);
//		System.out.println("你".getBytes("ASCII").length);
//		
		String a = "杩娆惧け璐 惧版璁㈠";
		String b = new String(a.getBytes("gbk"),"utf-16");
		String c = new String(a.getBytes("gbk"),"utf-32");
		String d = new String(a.getBytes("gbk"),"gbk");
		String e = new String(a.getBytes("gbk"),"utf-8");
		String f = new String(a.getBytes("gbk"),"ASCII");
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		
		
//		String str = "你好";
//		String enStr = URLEncoder.encode(str,"UTF-8");
//		System.out.println(enStr);
//		String deStr = URLDecoder.decode(enStr, "UTF-8");
//		System.out.println(deStr);
//		System.out.println(URLEncoder.encode(enStr,"GBK"));
	}
}
