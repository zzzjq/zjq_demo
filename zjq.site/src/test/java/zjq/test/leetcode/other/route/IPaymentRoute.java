package zjq.test.leetcode.other.route;

import java.util.List;

/**
 * 支付方式路由服务
 * 
 * 用户有多种支付方式（余额、红包、优惠券，代金券等），假如每种支付方式通过调用远程服务获取可用性。
 * 在外部资源环境不变情况下，请设计程序以最短响应时间获得尽可能多的可用支付方式列表。
 * 
 * 假定支付方式可用性咨询接口统一为 ConsultResultPaymentRemoteSerivce.isEnabled(String
 * paymentType); 返回结果
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
