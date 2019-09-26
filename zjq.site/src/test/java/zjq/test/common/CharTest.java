package zjq.test.common;

/**
 * 一个char占2个字节（byte），char类型也可以存储一个汉字，长度固定
 * String UTF-8 中文占3个字节，英文占1个字节,GBK中文占2个字节
 * 
 * @author:zhangjq
 * @time:2017年11月8日 下午3:38:01
 * @version:v1.0
 */
public class CharTest {

	public static byte[] charTobyte(char c){
    	byte[] bt = new byte[2];
    	bt[0] = (byte)((c & 0xFF00) >> 8);
    	bt[1] = (byte)(c & 0xFF);
    	return bt;
    }
	
	public static void main(String[] args) throws Exception{
    	char a = 'a';
    	char b = '我';
    	String c = "b";
    	String d = "你";
    	System.out.println(a + 100);
    	byte[] bt = charTobyte(a);
    	byte[] bt2 = charTobyte(b);
    	System.out.println(bt.length);
    	System.out.println(bt2.length);
    	System.out.println(c.getBytes().length);
    	System.out.println(d.getBytes().length);
    	System.out.println(d.getBytes("gbk").length);
    	System.out.println((char)97);
    }

}
