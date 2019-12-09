package zjq.test.leetcode.other.route;

/**
 * 支付方式可用性咨询接口
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午2:54:29
 *
 **/
public interface ConsultResultPaymentRemoteSerivce {

	/**
	 * 支付方式是否可用
	 * 
	 * @param paymentType
	 * @return
	 */
	public ConsultResult isEnabled(String paymentType);
}
