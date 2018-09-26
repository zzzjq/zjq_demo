package zjq.demo.exception;

/**
 * @author  zhangjingqi
 * @version V1.0
 * @Date	2016年3月31日下午5:55:35
 */

public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7262291673675012480L;

	public ServiceException(){
		super();
	}
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(Throwable cause){
		super(cause);
	}
	
	public ServiceException(String message,Throwable cause){
		super(message , cause);
	}
}

