package zjq.test.leetcode.other.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:30:24
 *
 **/
public class Money {

	private long cent;
	private Currency currency;
	private static final int[] centFactors = new int[] { 1, 10, 100, 1000 };

	public int getCentFactor() {
		return centFactors[currency.getDefaultFractionDigits()];
	}

	public Money(double amount) {
		this(amount, Currency.getInstance("CNY"));
	}

	public Money(double amount, Currency currency) {
		this.currency = currency;
		this.cent = Math.round(amount * getCentFactor());
	}

	public BigDecimal getAmount() {
		return BigDecimal.valueOf(cent, currency.getDefaultFractionDigits());
	}

}
