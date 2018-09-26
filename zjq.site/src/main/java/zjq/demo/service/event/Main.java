package zjq.demo.service.event;
/**
 *	@author zhangjq
 *	@date 	2018年4月24日 下午7:35:19
 *
 **/
public class Main {
	private static RealEvent event = new RealEvent();
	
	private static Subject subject;
	
	public static void main(String[] args) {
		subject = new Subject();
		subject.addListener(e-> System.out.println("这里是处理事件的具体方法体"));
		subject.notify(event);
	}
}

