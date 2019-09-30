package zjq.test.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author zhangjingqi
 * @date 2019年9月12日上午11:52:06
 *
 **/
public class UrlReadWrite {

	public static String urlReadWrite(String address) {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			URL url = new URL(address);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			InputStream in = httpURLConnection.getInputStream();
			int len;
			byte[] bt = new byte[1024];
			while ((len = in.read(bt)) != -1) {
				out.write(bt, 0, len);
			}
			return new String(out.toByteArray(), "utf-8");
		} catch (Exception e) {
		}
		return null;
	}

}
