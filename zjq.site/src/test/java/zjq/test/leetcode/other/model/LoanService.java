package zjq.test.leetcode.other.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

/**
 * 
 * @author zhangjingqi
 * @date 2019年12月9日下午7:49:44
 *
 **/
@Service
public class LoanService implements ILoan {

	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);

	@Override
	public CommonInstallmentVO buildLoan(String tradeNo, Money applyAmount, ALoanFeeInfo loanFeeInfo) {
		logger.info("获取分期模型开始，交易订单号 ：{}, 申请金额:{}", tradeNo, applyAmount.getAmount());
		CommonInstallmentVO commonInstallmentVO = new CommonInstallmentVO();
		List<CommonInstallmentItem> installmentItemList = null;
		commonInstallmentVO.setTradeNo(tradeNo);
		commonInstallmentVO.setApplyAmount(applyAmount.getAmount().toString());
		if (null != loanFeeInfo) {
			installmentItemList = new ArrayList<CommonInstallmentItem>();
			CommonInstallmentItem item = new CommonInstallmentItem();
			/** 期数 **/
			item.setInstallCount(loanFeeInfo.getPeriod());
			/** 商户贴息比率 **/
			item.setPartnerDiscountRatio(new BigDecimal(loanFeeInfo.getPartnerDiscountRatio()));
			/** 卖家贴息比率 **/
			item.setSellerDiscountRatio(new BigDecimal(loanFeeInfo.getSellerDiscountRatio()));
			/** 1 - 商户贴息比率 - 卖家贴息比率 **/
			item.setDiscountWithBenefitInterest(new BigDecimal("1.00").subtract(item.getPartnerDiscountRatio())
					.subtract(item.getSellerDiscountRatio()));
			installmentItemList.add(item);
			commonInstallmentVO.setInstallmentItemList(installmentItemList);
		}
		logger.info("获取分期模型结束，commonInstallmentVO ：" + JSON.toJSONString(commonInstallmentVO));
		return commonInstallmentVO;
	}

	@Override
	public List<LoanCalcResult> getCalcResult(CommonInstallmentVO commonInstallmentVO) {
		logger.info("获取分期费率开始，CommonInstallmentVO ：" + JSON.toJSONString(commonInstallmentVO));
		if (null == commonInstallmentVO || null == commonInstallmentVO.getInstallmentItemList()
				|| commonInstallmentVO.getInstallmentItemList().size() < 1) {
			logger.error("获取分期费率异常，CommonInstallmentVO error" + JSON.toJSONString(commonInstallmentVO));
			return null;
		}
		List<CommonInstallmentItem> installmentItemList = commonInstallmentVO.getInstallmentItemList();
		List<LoanCalcResult> result = new ArrayList<LoanCalcResult>();
		/** 申请金额 **/
		BigDecimal applyAmount = new BigDecimal(commonInstallmentVO.getApplyAmount());
		installmentItemList.forEach(e -> {
			LoanCalcResult loanCalcResult = new LoanCalcResult();
			loanCalcResult.setTradeNo(commonInstallmentVO.getTradeNo());
			/** 总费用 = 申请金额*期数*买家贴息比率*原始费率 **/
			Money totalFee = new Money(applyAmount.multiply(new BigDecimal(e.getInstallCount()))
					.multiply(e.getDiscountWithBenefitInterest())
					.multiply(new BigDecimal(BuyerRate.getRate(e.getInstallCount()))).doubleValue());
			/** 每期费用 = 总费用/期数 **/
			Money eachFee = new Money(totalFee.getAmount()
					.divide(new BigDecimal(e.getInstallCount()), BigDecimal.ROUND_DOWN).doubleValue());
			/** 每期本金+费用 = 申请金额/期数 + 每期费用 **/
			Money eachPrinAndFee = new Money((eachFee.getAmount()
					.add(applyAmount.divide(new BigDecimal(e.getInstallCount()), BigDecimal.ROUND_DOWN))
					.doubleValue()));
			loanCalcResult.setTotalFee(totalFee);
			loanCalcResult.setEachFee(eachFee);
			loanCalcResult.setEachPrinAndFee(eachPrinAndFee);
			result.add(loanCalcResult);
		});
		logger.info("获取分期费率结束，result ：" + JSON.toJSONString(result));
		return result;
	}

	public static void main(String[] args) {
		ILoan i = new LoanService();
		CommonInstallmentVO vo = i.buildLoan("20000010010101000330400", new Money(6000), ALoanFeeInfo.THREE);
		i.getCalcResult(vo);
	}

}
