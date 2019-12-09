package zjq.test.leetcode.other.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 分期模型
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:32:52
 *
 **/
@Getter
@Setter
public class CommonInstallmentVO {
	/** 交易号 */
	private String tradeNo;

	/** 申请金额 */
	private String applyAmount;

	/** 分期列表，这个交易号下各个分期的信息，支持不同的还款方式 */
	private List<CommonInstallmentItem> installmentItemList = new ArrayList<CommonInstallmentItem>();
}
