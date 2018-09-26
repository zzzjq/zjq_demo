package zjq.demo.dao;

import java.util.List;

import zjq.demo.model.PartnerConfig;

/**
 * @author:zhangjq
 * @time:2017年9月7日 下午5:28:13
 * @version:v1.0
 */
public interface PartnerConfigMapper {

	List<PartnerConfig> query(PartnerConfig partnerConfig);
}
