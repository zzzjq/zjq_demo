package zjq.test.leetcode.other.route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付方式路由服务
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午2:53:31
 *
 **/
@Service
public class PaymentRouteService implements IPaymentRoute{

	@Autowired
	private ConsultResultPaymentRemoteSerivce consultResultPaymentRemoteSerivce;

	private final List<String> paymentTypes = 
			Arrays.asList("balance", "card", "redpacket", "coupon", "voucher");

	private ExecutorService executorService = new ThreadPoolExecutor(
			Runtime.getRuntime().availableProcessors(),
			Runtime.getRuntime().availableProcessors(), 100L, TimeUnit.MILLISECONDS,
			new ArrayBlockingQueue<Runnable>(64));

	@Override
	public List<String> getEnablePayment() {
		/** 返回可用的支付方式 **/
		List<String> result = new ArrayList<String>(paymentTypes.size());
		for (String paymentType : paymentTypes) {
			if (isEnable(paymentType))
				result.add(paymentType);
		}
		return result;
	}

	/**
	 * 多线程获取支付方式是否可用，超时时间1秒
	 * 
	 * @param paymentType
	 * @return
	 */
	private boolean isEnable(String paymentType) {
		try {
			FutureTask<Boolean> f = new FutureTask<Boolean>(new Route(paymentType));
			executorService.submit(f);
			return f.get(1L, TimeUnit.SECONDS);
		} catch (Exception e) {
			return false;
		}
	}
	
	/** 支付方式远程调用类 **/
	class Route implements Callable<Boolean> {

		private String paymentType;

		public Route(String paymentType) {
			this.paymentType = paymentType;
		}

		@Override
		public Boolean call() throws Exception {
			try {
				ConsultResult consultResult = consultResultPaymentRemoteSerivce.isEnabled(this.paymentType);
				if (consultResult.isEnable())
					return true;
			} catch (Exception e) {
			}
			return false;
		}
	}

}
