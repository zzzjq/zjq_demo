package zjq.demo.annotation;

import java.lang.reflect.Field;

/**
 * 注解解析器
 * 
 * @author zhangjingqi
 * @date 2019年6月12日下午6:22:00
 *
 **/
public class AnnotationHandler {

	public static String notNull(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			NotNull notNull = f.getDeclaredAnnotation(NotNull.class);
			if (notNull != null) {
				try {
					Object v = f.get(o);
					if (v == null)
						return notNull.value();
				} catch (Exception e) {
					return null;
				}
			}
		}
		return null;
	}
}
