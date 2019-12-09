package zjq.test.leetcode.other.loan;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:10:42
 *
 **/
@Getter
@Setter
public class Loan {

	private String id;
	private Integer ovdDays;
	private BigDecimal rate;
	private Date startDate;
	private BigDecimal amount;
	// 其他字段…
}
