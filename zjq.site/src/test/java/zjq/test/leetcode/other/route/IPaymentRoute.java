package zjq.test.leetcode.other.route;

import java.util.List;

/**
 * 支付方式路由服务
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午3:45:48
 *
 **/
public interface IPaymentRoute {

	/**
	 * 获取可用支付方式
	 * 
	 * @return
	 */
	List<String> getEnablePayment();

}
