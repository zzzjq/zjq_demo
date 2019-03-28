package zjq.demo.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地缓存
 * @author:zhangjq
 * @time:2017年7月14日 上午9:52:48
 * @version:v1.0
 */
public class LocalCache {

	/**容器**/
	private static ConcurrentHashMap<String, Content> map = new ConcurrentHashMap<String, Content>();
	
	/**检测过期任务**/
	static{
		try{
			Thread thread = new Thread(new AA());
			thread.start();
		}
		catch(Exception e){
			
		}
	}
	
	/**线程检测**/
	private static class AA implements Runnable{
		@Override
		public void run() {
			while(true){
				check();
			}
		}
	}
	
	/**过期删除**/
	private static void check(){
		if(map.size() >0){
			for(Map.Entry<String, Content> entry : map.entrySet()){
				Content c = entry.getValue();
				if(System.currentTimeMillis() - c.getCreateTime() > c.getCacheMillis()){
					map.remove(entry.getKey());
				}
			}
		}
	}
	
	private LocalCache(){}
	
	/**静态内部类**/
	private static class GetCache{
		private static final LocalCache cache = new LocalCache();
	}
	
	/**静态工厂，保持单例**/
	public static LocalCache getLocalCache(){
		return GetCache.cache;
	}
	
	/**获取值**/
	public Object getValue(String key){
		Content c = map.get(key);
		if(null == c)
			return null;
		
		long currentTime = System.currentTimeMillis();
		
		/**获取的时候刚好过期**/
		if(c.getCacheMillis() >0 && currentTime - c.getCreateTime() > c.getCacheMillis()){
			map.remove(key);
			return null;
		}

		return c.getElement();
	}
	
	/**设置值**/
	/**key和value不能为空，过期时间不能小于等于0**/
	public boolean setValue(String key, int cacheMillis, Object value){
		long currentTime = System.currentTimeMillis();
		if(cacheMillis <= 0)
			return false;
		if("".equals(key) || key == null)
			return false;
		if(null == value)
			return false;
		Content c = new Content(cacheMillis, value, currentTime);
		map.put(key, c);
		return true;
	}
	
	/**内部对象**/
	private class Content{
		/**过期时间**/
        private int cacheMillis;  
        /**值**/
        private Object element;  
        /**创建时间**/  
        private long createTime ;
        
        public Content(int cacheMillis, Object element, long createTime){
        	this.cacheMillis = cacheMillis;
        	this.element = element;
        	this.createTime = createTime;
        }
        
		public int getCacheMillis() {
			return cacheMillis;
		}

		public Object getElement() {
			return element;
		}

		public long getCreateTime() {
			return createTime;
		}
 
	}

}
