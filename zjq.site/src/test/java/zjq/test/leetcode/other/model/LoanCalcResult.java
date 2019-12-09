package zjq.test.leetcode.other.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:31:43
 *
 **/
@Getter
@Setter
public class LoanCalcResult {

	/** 订单号 */
	private String tradeNo;
	/** 总费用 */
	private Money totalFee;
	/** 每期费用 */
	private Money eachFee;
	/** 每期本金+费用 */
	private Money eachPrinAndFee;
	
}
