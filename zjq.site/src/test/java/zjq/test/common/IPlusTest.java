package zjq.test.common;

/**
 * 自增(++):将变量的值加1，分前缀式(如++i)和后缀式(如i++)。前缀式是先加1再使用;后缀式是先使用再加1
 * 自减(--):将变量的值减1，分前缀式(如--i)和后缀式(如i--)。前缀式是先减1再使用;后缀式是先使用再减1
 * 
 * @author zhangjq
 * @date 2019年2月20日下午4:09:59
 *
 **/
public class IPlusTest {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int k = i++ + ++i; //0 + 2 
		int k2 = ++j + j++; //1 + 1
		System.out.println(k);
		System.out.println(k2);
		int i2 = 0;
		int j2 = i2 ++; //j2=0, i2=1 // 先将i2的原始值赋值给变量j2，然后i变量的值加1
		int i3 = 0;
		int j3 = ++ i3; //j3=1, i3=1 // 先将i3变量的值加1，然后将i3的当前值赋值给变量j3
		System.out.println(j2);
		System.out.println(j3);
	}
}
