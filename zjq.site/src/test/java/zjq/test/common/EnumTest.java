package zjq.test.common;
/**
 * @author:zhangjq
 * @time:2017年12月29日 下午4:30:24
 * @version:v1.0
 */
public enum EnumTest{

	NAME("name","zjq"),ID("id","123"),SEX("","");
	
	private String name;
	
	private String desc;
	
	private EnumTest(String name, String desc){
		this.setName(name);
		this.setDesc(desc);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	private void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
