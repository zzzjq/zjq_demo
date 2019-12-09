package zjq.test.leetcode.other.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:31:07
 *
 **/
@Getter
@Setter
public class LoanCalcParam {
	/** 总期数 */
	private int totalInstall;
	/** 申贷金额 */
	private Money applyAmount;
	/** 折后利率 */
	private BigDecimal discountWithBenefitInterest;
}
