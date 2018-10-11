package zjq.demo.util;

import java.math.BigDecimal;

/**
 * 金额工具类
 * @author zhangjq
 * @date 2018年10月11日下午5:24:35
 *
 **/
public class BigDecimalUtil {
	
    public static double add(double d1, double d2) {        // 进行加法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }

    public static double sub(double d1, double d2) {        // 进行减法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(double d1, double d2) {        // 进行乘法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2).doubleValue();
    }

    public static BigDecimal div(double d1, double d2, int len) {// 进行除法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP);
    }

    public static double round(double d, int len) {     // 进行四舍五入
        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        // 任何一个数字除以1都是原数字
        // ROUND_HALF_UP是BigDecimal的一个常量，
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * bigdecimal 元 转换 成 long 厘
     * @param sourceMoney
     * @return
     */
    public static Long convertBigDecimalMoney(BigDecimal sourceMoney) {
        if (sourceMoney==null) {
            return 0L;
        }
        return sourceMoney.multiply(new BigDecimal("1000")).toBigInteger().longValue();
    }
    
    
	/**
	 * String元转换成 BigDecimal 厘
	 * 
	 * @param sourceMoney
	 * @return
	 */
	public static BigDecimal convertBigDecimal(String sourceMoney) {
		if (sourceMoney == null) {
			return null;
		}
		return new BigDecimal(sourceMoney).multiply(new BigDecimal("1000"));
	}
	
	/**
	 * String 元 转 long 厘
	 * 
	 * @param StrBd
	 * @return
	 */
	public static Long convertStringYuanToLongLi(String StrBd) {
		BigDecimal bd = new BigDecimal(StrBd);
		// 设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return convertBigDecimalMoney(bd);
	}
    
	/**
	 * BigDecimal元转换为BigDecimal厘
	 *
	 * @param amt
	 * @return
	 */
	public static BigDecimal convertToLi(BigDecimal amt) {
		if (amt == null) {
			return null;
		}
		return amt.multiply(new BigDecimal("1000"));
	}
      
    


    /**
     * String 元 转 long 厘convertBigDecimalMoney
     * @param StrBd
     * @return
     */
    public static BigDecimal convertBigDecimalMoney(String StrBd){
        BigDecimal bd = new BigDecimal(StrBd);
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("1000")).setScale(0, BigDecimal.ROUND_HALF_UP);
        if (bd==null) {
            return new BigDecimal(0);
        }
        return bd;
    }

    /**
     * long 厘 转换成 bigdecimal 元
     * @param sourceMoney
     * @return
     */
    public static BigDecimal convertLongLiToBigDecimalYuan(Long sourceMoney) {
        if (sourceMoney==null) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(sourceMoney);
        return bigDecimal.movePointLeft(3).setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * long 厘 转换成 bigdecimal 元
     * @param sourceMoney
     * @return
     */
    public static String convertBigDecimalMoneyStr(Long sourceMoney) {
        if (sourceMoney==null) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(sourceMoney);
        return bigDecimal.movePointLeft(3).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * long 厘 转换成 bigdecimal 元
     * @param sourceMoney
     * @return
     */
    public static String convertStringMoney(Long sourceMoney) {
        if (sourceMoney==null) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(sourceMoney);
        return String.valueOf(bigDecimal.movePointLeft(3).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    /**
     * long 厘 转换成 分
     * @param sourceMoney
     * @return
     */
    public static String convertStringMoneyTofen(Long sourceMoney) {
        if (sourceMoney==null) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(sourceMoney);
        int result = bigDecimal.divide(new BigDecimal("10")).intValue();
       return String.format("%015d",result);
    }  

    /**
     * 将厘值金额转为元值金额
     * @param liValue
     * @return
     */
    public static double liToYuan(Long liValue){
        if(liValue != null){
            BigDecimal bd1 = new BigDecimal(liValue);
            BigDecimal bd2 = new BigDecimal(1000);
            return bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        }else{
            return 0;
        }
    }

    /**
     * String 分 转 long 厘
     * @param StrBd
     * @return
     */
    public static Long convertFenToLi(String StrBd){
        BigDecimal bd = new BigDecimal(StrBd);
        return bd.multiply(new BigDecimal("10")).toBigInteger().longValue();
    }

    /**
     * String 厘 转 long 分
     * @param amount
     * @return
     */
    public static Long convertLiToFen(long amount){
        BigDecimal bd = new BigDecimal(amount);
        return bd.movePointLeft(1).longValue();
    }
    
    /**
     * BigDecimal厘金额转换为BigDecimal元,保留两位小数
     *
     * @param amt
     * @return
     */
    public static BigDecimal convertToYuan(BigDecimal amt) {
        return new BigDecimal(amt.longValue() * 1.0 / 1000).setScale(2, BigDecimal.ROUND_HALF_UP);
    }    
    
    /**
	 * 将厘值金额转为元值金额
	 * @param liValue 
	 * @return
	 */
	public static String liToYuanString(Long liValue){
		if(liValue != null){
			BigDecimal bd1 = new BigDecimal(liValue);
			BigDecimal bd2 = new BigDecimal(1000);
			return bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_EVEN).toString();
		}else{
			return "0.00";
		}
	}

}
