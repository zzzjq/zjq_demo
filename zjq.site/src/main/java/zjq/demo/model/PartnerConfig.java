package zjq.demo.model;

/**
 * @author:zhangjq
 * @time:2017年9月7日 下午5:26:45
 * @version:v1.0
 */
public class PartnerConfig {

	private Long partnerConfigNo;

	private Long memberCode;

	private String paramCode;

	private String description;

	private String value;

	private String remark;
	
	public String demo1;
	
	public String demo2;

	public Long getPartnerConfigNo() {
		return partnerConfigNo;
	}

	public void setPartnerConfigNo(Long partnerConfigNo) {
		this.partnerConfigNo = partnerConfigNo;
	}

	public Long getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(Long memberCode) {
		this.memberCode = memberCode;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
