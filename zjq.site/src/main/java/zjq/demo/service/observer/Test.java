package zjq.demo.service.observer;
/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:52:04
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args){
		Subject subject = new MySubject();
		subject.add(new Observer1());
		subject.add(new Observer2());
		
		subject.operator();
	}
}
