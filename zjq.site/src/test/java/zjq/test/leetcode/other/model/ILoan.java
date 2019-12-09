package zjq.test.leetcode.other.model;

import java.util.List;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:48:20
 *
 **/
public interface ILoan {

	/**
	 * 获取分期模型
	 * 
	 * @param tradeNo
	 * @param applyAmount
	 * @param period
	 * @return
	 */
	CommonInstallmentVO buildLoan(String tradeNo, Money applyAmount, ALoanFeeInfo loanFeeInfo);

	/**
	 * 获取分期费率
	 * 
	 * @param commonInstallmentVO
	 * @return
	 */
	List<LoanCalcResult> getCalcResult(CommonInstallmentVO commonInstallmentVO);
	
}
