package zjq.test.leetcode.other.model;

import java.util.List;

/**
 * 1、编写订单的分期模型，请自行设计接口实现如下功能。
 * 存在贴息情况，贴息情况如下aloan_fee_info=3_P40_S0;6_P0_S33.33;12_P20_S10(说明3代表期数，P代表平台贴息百分比，S代表卖家贴息百分比，剩余由买家贴息)；
 * 原始费率如下所示，支持3，6，12，24期模式，每种模式的总费率见buyerRate；
 * 买家的手续费计算逻辑是申请金额*期数*买家贴息比例*原始费率，比如一个用户申请6000块分期，其中3_P40_S0的3期总费用=6000*3*（1-0.4-0）*0.025=270,
 * 分期每期费用 = 总费用/总期数，分期每期总本金加上总费用 = 总本金/总期数 + 总费用/总期数，取小数数规则是BigDecimal.ROUND_DOWN。
 * 假设给定一笔分期交易单号是20000010010101000330400，申请金额是6000，贴息情况aloan_fee_info=3_P40_S0;6_P0_S33.33;12_P20_S10。
 * 第一步组装分期模型PcreditCommonInstallmentVO，
 * 第二步将分期模型作为费用计算的入参，算出分期的费率情况List<LoanCalcResult>。
 * 注：构建分期模型入参tradeNo,aloan_fee_info=3_P40_S0;6_P0_S33.33;12_P20_S10，applyAmount=6000，Money金额单位cent为分，展示amount为元，出参为CommonInstallmentVO；
 * 计算分期模型入参为CommonInstallmentVO，出参为List<LoanCalcResult>，其中计算每期费用的入参请用LoanCalcParam。
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:48:20
 *
 **/
public interface ILoan {

	/**
	 * 获取分期模型
	 * 
	 * @param tradeNo
	 * @param applyAmount
	 * @param period
	 * @return
	 */
	CommonInstallmentVO buildLoan(String tradeNo, Money applyAmount, ALoanFeeInfo loanFeeInfo);

	/**
	 * 获取分期费率
	 * 
	 * @param commonInstallmentVO
	 * @return
	 */
	List<LoanCalcResult> getCalcResult(CommonInstallmentVO commonInstallmentVO);

}
