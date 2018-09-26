package zjq.demo.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取置顶配置文件的字段值
 * path(文件路径)
 * key(字段名称)
 * @author:zhangjq
 * @time:2017年5月23日 下午2:26:42
 * @version:v1.0
 */
public class PropertiesUtil {

	public static String getProp(String path, String key){
		String value = null;
		Properties pro = new Properties();
		InputStream in = null;
		try {
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
			pro.load(in);
			value = pro.getProperty(key);
			return value;
		} catch (FileNotFoundException e) {
			return "";
		} catch (IOException e) {
			return "";
		} finally{
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
