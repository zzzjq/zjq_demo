package zjq.demo.util.cache;

/**
 * @author:zhangjq
 * @time:2017年7月14日 上午9:56:57
 * @version:v1.0
 */
public class LocalCacheTest {

	public static void main(String[] args) throws Exception{

		LocalCache cache = LocalCache.getLocalCache();
		LocalCache cache2 = LocalCache.getLocalCache();
		LocalCache cache3 = cache2.getLocalCache();
		//验证单例
		System.out.println(cache.equals(cache2));
		System.out.println(cache == cache2);
		System.out.println(cache2.equals(cache3));
		System.out.println(cache2 == cache3);
		System.out.println(cache.equals(cache3));
		System.out.println(cache == cache3);
		//验证插入，获取
		cache.setValue("11", 1000, "111");
		System.out.println(cache.getValue("11"));
		System.out.println(cache2.getValue("11"));
		Thread.sleep(800);
		//验证过期删除
		System.out.println(cache.getValue("11"));
		System.out.println(cache2.getValue("11"));
		Thread.sleep(250);
		System.out.println(cache.getValue("11"));
		System.out.println(cache2.getValue("11"));
	}
}
