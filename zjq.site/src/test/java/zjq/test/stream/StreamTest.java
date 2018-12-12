package zjq.test.stream;

import java.util.stream.Stream;

/**
 * 
 * @author zhangjq
 * @date 2018年12月12日下午5:19:49
 *
 **/
public class StreamTest {

	public static void main(String[] args) {
		/**Stream.generate和Stream.iterate 显示创建无限流，需要limit来控制**/
		Stream.generate(Math::random).limit(10).forEach(e -> System.out.println(e));
		Stream.iterate(0, e -> e+1).limit(10).forEach(e -> System.out.println(e));
		/**斐波那契数列**/
		Stream.iterate(new int[] {0,1}, e -> new int[] {e[1], e[0] + e[1]}).limit(10)
			.forEach(e -> System.out.println(e[0]));
	}
}
