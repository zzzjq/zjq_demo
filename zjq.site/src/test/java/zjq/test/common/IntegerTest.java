package zjq.test.common;
/**
 * @author:zhangjq
 * @time:2017年9月5日 下午6:07:10
 * @version:v1.0
 */
public class IntegerTest {

	public static void main(String[] args){
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c==d);
		System.out.println(c.equals(d));
		System.out.println(c==(a+b));
		System.out.println(c.equals(a+b));
		System.out.println(e==f);
		System.out.println(e.equals(f));
		System.out.println(g==(a+b));
		System.out.println(g.equals(a+b));
	}
}
