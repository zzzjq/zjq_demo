package zjq.demo.service.resChain;

/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:16:06
 * @version:v1.0
 */
public abstract class AbstractHandler {
	private Handle handle;

	public Handle getHandle() {
		return handle;
	}

	public void setHandle(Handle handle) {
		this.handle = handle;
	}

}
