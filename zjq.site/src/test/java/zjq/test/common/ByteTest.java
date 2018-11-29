package zjq.test.common;

/**
 * byte test
 * 
 * @author:zhangjq
 * @time:2017年7月6日 下午6:02:21
 * @version:v1.0
 */
public class ByteTest {

	// 数组的toString 返回的是内存地址。不是之前是String对象。要重新生成指向这个地址的String对象
	public static void main(String args[]) {
		String example = "This is an example";
		byte[] bytes = example.getBytes();

		System.out.println("Text : " + example);
		System.out.println("Text [Byte Format] : " + bytes);
		System.out.println("Text [Byte Format] : " + bytes.toString());

		String s = new String(bytes);
		System.out.println("Text Decryted : " + s);
	}

}
