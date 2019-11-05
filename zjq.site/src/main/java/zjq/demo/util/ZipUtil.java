package zjq.demo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * zip压缩流
 * 
 * @author:zhangjq
 * @time:2017年6月29日 下午2:18:46
 * @version:v1.0
 */
public class ZipUtil {
	
	public static String compress(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				GZIPOutputStream gzip = new GZIPOutputStream(out);) {
			gzip.write(str.getBytes("UTF-8"));
			gzip.close();
			return out.toString("ISO-8859-1");
		} catch (Exception e) {
			return null;
		}

	}

	public static String uncompress(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
				GZIPInputStream gunzip = new GZIPInputStream(in);) {
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			// toString()使用平台默认编码，也可以显式的指定如toString("GBK")
			return out.toString("UTF-8");
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		String src = new String(
				"{\"name\":\"中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人中国人\"}");

		String src2 = new String(
				"abcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmoabcdefghijklmo");

		System.out.println("src:" + src);
		System.out.println("src.bytes.length:" + src.getBytes().length);

		System.out.println("src2:" + src2);
		System.out.println("src2.bytes.length:" + src2.getBytes().length);

		String tmp = ZipUtil.compress(src);
		System.out.println(tmp);
		System.out.println(tmp.getBytes().length);

		String tmp2 = ZipUtil.compress(src2);
		System.out.println(tmp2);
		System.out.println(tmp2.getBytes().length);

		System.out.println(ZipUtil.uncompress(tmp));
		System.out.println(ZipUtil.uncompress(tmp2));
	}

}
