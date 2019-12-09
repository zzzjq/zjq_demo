package zjq.test.leetcode.other.loan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

import zjq.demo.util.DateUtil;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:12:01
 *
 **/
public class LoanUtil {

	public static List<Loan> sortLoan(List<Loan> list) {
		if(null == list || list.size() < 2)
			return null;
		return list.stream().sorted(Comparator.comparing(Loan::getOvdDays)
				.thenComparing(Loan::getRate).reversed()
				.thenComparing(Loan::getStartDate)
				.thenComparing(Loan::getId)).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<Loan> list = new ArrayList<Loan>();
		Loan loan1 = new Loan();
		loan1.setId("1");
		loan1.setOvdDays(60);
		loan1.setRate(new BigDecimal("0.15"));
		loan1.setStartDate(DateUtil.getPrevDate(new Date()));
		Loan loan2 = new Loan();
		loan2.setId("2");
		loan2.setOvdDays(60);
		loan2.setRate(new BigDecimal("0.25"));
		loan2.setStartDate(new Date());
		Loan loan3 = new Loan();
		loan3.setId("3");
		loan3.setOvdDays(80);
		loan3.setRate(new BigDecimal("0.35"));
		loan3.setStartDate(DateUtil.getPrevDate(new Date()));
		list.add(loan1);
		list.add(loan2);
		list.add(loan3);
		List<Loan> list2 = sortLoan(list);
		list2.forEach(e -> {System.out.println(JSON.toJSONString(e));});
	}
}
