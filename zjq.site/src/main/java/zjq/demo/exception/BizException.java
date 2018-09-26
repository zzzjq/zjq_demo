package zjq.demo.exception;
/**
 * 业务层异常
 * 
 * @author  zhangjingqi
 * @version V1.0
 * @Date	2016年3月31日下午5:38:20
 */

public class BizException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -706361161690086649L;

	public BizException(){
		super();
	}
	
	public BizException(String message){
		super(message);
	}
	
	public BizException(Throwable cause){
		super(cause);
	}
	
	public BizException(String message,Throwable cause){
		super(message , cause);
	}
}

