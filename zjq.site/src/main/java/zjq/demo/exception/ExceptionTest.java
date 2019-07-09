package zjq.demo.exception;

/**
 * 
 * @author zhangjingqi
 * @date 2019年7月9日下午5:58:02
 *
 **/
public class ExceptionTest {

	public static void main(String[] args) {
		try {
			throw new Exception("1111");
		} catch (BizException e) {
			System.out.println(e.getMessage());
			//加了return，不会执行222；finally不管return，都会执行
			return;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally block");
		}
		System.out.println("222");
	}
}
