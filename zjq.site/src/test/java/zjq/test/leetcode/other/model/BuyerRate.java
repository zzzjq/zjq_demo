package zjq.test.leetcode.other.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 原始费率
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:46:23
 *
 **/
public enum BuyerRate {

	THREE(3, "0.025"), SIX(6, "0.025"), TWELVE(12, "0.05"), TEWETY(24, "0.1"),;
	@Getter
	@Setter
	private Integer period;
	@Getter
	@Setter
	private String rate;

	private BuyerRate(Integer period, String rate) {
		this.period = period;
		this.rate = rate;
	}

	public static String getRate(Integer period) {
		if (null == period || period < 3 || period > 24)
			return null;
		for (BuyerRate buyerRate : BuyerRate.values()) {
			if (buyerRate.getPeriod().equals(period))
				return buyerRate.getRate();
		}
		return null;
	}

}
