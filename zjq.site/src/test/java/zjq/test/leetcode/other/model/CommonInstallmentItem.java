package zjq.test.leetcode.other.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * 分期信息
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:32:22
 *
 **/
@Getter
@Setter
public class CommonInstallmentItem {

	/** 期数 */
	private int installCount;
	/** 折后利率 */
	private BigDecimal discountWithBenefitInterest;
	/** 商户贴息比率 */
	private BigDecimal partnerDiscountRatio;
	/** 卖家贴息比率 */
	private BigDecimal sellerDiscountRatio;

}
