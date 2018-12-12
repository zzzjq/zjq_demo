package zjq.test.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author zhangjq
 * @date 下午12:13:26
 *
 **/
public class ComparatorTest {

	static class LoanLenderItem {
		private String borrowNo;

		private Integer period;

		public String getBorrowNo() {
			return borrowNo;
		}

		public void setBorrowNo(String borrowNo) {
			this.borrowNo = borrowNo;
		}

		public Integer getPeriod() {
			return period;
		}

		public void setPeriod(Integer period) {
			this.period = period;
		}

	}

	public static void main(String[] args) throws Exception {
		List<LoanLenderItem> loanLenderItems = new ArrayList<LoanLenderItem>(6);
		LoanLenderItem e6 = new LoanLenderItem();
		e6.setBorrowNo("1000000000001");
		e6.setPeriod(6);
		LoanLenderItem e4 = new LoanLenderItem();
		e4.setBorrowNo("1000000000001");
		e4.setPeriod(9);
		LoanLenderItem e5 = new LoanLenderItem();
		e5.setBorrowNo("1000000000003");
		e5.setPeriod(4);
		LoanLenderItem e1 = new LoanLenderItem();
		e1.setBorrowNo("1000000000000");
		e1.setPeriod(1);
		LoanLenderItem e2 = new LoanLenderItem();
		e2.setBorrowNo("1000000000000");
		e2.setPeriod(2);
		LoanLenderItem e3 = new LoanLenderItem();
		e3.setBorrowNo("1000000000000");
		e3.setPeriod(3);
		loanLenderItems.add(e6);
		loanLenderItems.add(e2);
		loanLenderItems.add(e4);
		loanLenderItems.add(e1);
		loanLenderItems.add(e5);
		loanLenderItems.add(e3);
		loanLenderItems.forEach(e -> System.out.println(JSON.toJSONString(e)));
		System.out.println("=====");
//		Collections.sort(loanLenderItems, new Comparator<LoanLenderItem>() {
//			@Override
//			public int compare(LoanLenderItem o1, LoanLenderItem o2) {
//				if (Long.parseLong(o1.getBorrowNo()) > Long.parseLong(o2.getBorrowNo())) {
//					return 1;
//				} else if (Long.parseLong(o1.getBorrowNo()) == Long.parseLong(o2.getBorrowNo())) {
//					if (o1.getPeriod() >= o2.getPeriod()) {
//						return 1;
//					}
//					return -1;
//				} else {
//					return -1;
//				}
//			}
//		});

		Thread.sleep(1000);
		/**stream升级版排序**/
		loanLenderItems = loanLenderItems.stream()
				.sorted(Comparator.comparing(LoanLenderItem::getBorrowNo).thenComparing(LoanLenderItem::getPeriod))
				.collect(Collectors.toList());
		loanLenderItems.forEach(e -> System.out.println(JSON.toJSONString(e)));
	}

}
