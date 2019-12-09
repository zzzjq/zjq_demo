package zjq.test.leetcode.other.route;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 支付方式可用结果
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午2:54:59
 *
 **/
@Getter
@Setter
public class ConsultResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4780922915855236225L;

	/** 咨询结果是否可用 */
	private boolean enable;

	/** 错误码 */
	private String errorCode;

}
