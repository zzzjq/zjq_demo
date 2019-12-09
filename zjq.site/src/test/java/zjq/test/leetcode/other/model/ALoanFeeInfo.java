package zjq.test.leetcode.other.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 贴息情况
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:44:56
 *
 **/
public enum ALoanFeeInfo {

	THREE(3, "0.4", "0"), SIX(6, "0", "33.33"), TWELVE(12, "0.2", "0.1"),;
	@Getter
	@Setter
	private Integer period;
	@Getter
	@Setter
	private String partnerDiscountRatio;
	@Getter
	@Setter
	private String sellerDiscountRatio;

	private ALoanFeeInfo(Integer period, String partnerDiscountRatio, String sellerDiscountRatio) {
		this.period = period;
		this.partnerDiscountRatio = partnerDiscountRatio;
		this.sellerDiscountRatio = sellerDiscountRatio;
	}

	public static ALoanFeeInfo getFeeInfoByPeriod(Integer period) {
		if (null == period || period < 3 || period > 24)
			return null;
		for (ALoanFeeInfo info : ALoanFeeInfo.values()) {
			if (info.getPeriod().equals(period))
				return info;
		}
		return null;
	}

}
