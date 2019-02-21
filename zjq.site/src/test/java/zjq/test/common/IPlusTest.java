package zjq.test.common;

/**
 * 自增(++):将变量的值加1，分前缀式(如++i)和后缀式(如i++)。前缀式是先加1再使用;后缀 式是先使用再加1
 * 自减(--):将变量的值减1，分前缀式(如--i)和后缀式(如i--)。前缀式是先减1再使用;后缀式是 先使用再减1
 * 
 * @author zhangjq
 * @date 2019年2月20日下午4:09:59
 *
 **/
public class IPlusTest {

	public static void main(String[] args) {
		int i = 0;
		int j = i++ + ++i;
		int k = --i + i--;
		System.out.println(j);
		System.out.println(k);
	}
}
