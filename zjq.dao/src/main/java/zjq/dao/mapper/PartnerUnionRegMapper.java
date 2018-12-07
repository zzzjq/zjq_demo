package zjq.dao.mapper;

import java.util.List;

import zjq.dao.model.PartnerUnionReg;

/**
 * @author:zhangjq
 * @time:2017年12月26日 上午11:35:49
 * @version:v1.0
 */
public interface PartnerUnionRegMapper {

	List<PartnerUnionReg> query(PartnerUnionReg partnerUnionReg);
	
	int insert(PartnerUnionReg partnerUnionReg);
}
