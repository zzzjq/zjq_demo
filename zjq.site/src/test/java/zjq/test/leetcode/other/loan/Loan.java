package zjq.test.leetcode.other.loan;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 排序优先ovdDays天数
 * 再rate从大到小
 * 再startDate小的
 * 都一样就按照id升序
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
