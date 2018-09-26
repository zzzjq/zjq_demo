package zjq.demo.util.rsa.jks;

import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import zjq.demo.util.HexUtil;

/**
 * X509格式证书
 * @author:zhangjq
 * @time:2017年7月7日 下午5:01:07
 * @version:v1.0
 */
public class CertUtil {
	public static X509Certificate getX509CerCate(String cerPath) throws Exception {  
        X509Certificate x509Certificate = null;  
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");  
        FileInputStream fileInputStream = new FileInputStream(cerPath);  
        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);  
        fileInputStream.close();  
        System.out.println("读取Cer证书信息...");  
        System.out.println("x509Certificate_SerialNumber_序列号___:"+x509Certificate.getSerialNumber());  
        System.out.println("x509Certificate_getIssuerDN_发布方标识名___:"+x509Certificate.getIssuerDN());   
        System.out.println("x509Certificate_getSubjectDN_主体标识___:"+x509Certificate.getSubjectDN());  
        System.out.println("x509Certificate_getSigAlgOID_证书算法OID字符串___:"+x509Certificate.getSigAlgOID());  
        System.out.println("x509Certificate_getNotBefore_证书有效期___:"+x509Certificate.getNotAfter());  
        System.out.println("x509Certificate_getSigAlgName_签名算法___:"+x509Certificate.getSigAlgName());  
        System.out.println("x509Certificate_getVersion_版本号___:"+x509Certificate.getVersion());  
        System.out.println("x509Certificate_getPublicKey_公钥___:"+x509Certificate.getPublicKey());  
        byte[] bt = x509Certificate.getPublicKey().getEncoded();
        String key = HexUtil.toHexString(bt);
        System.out.println("PUBLICKEY :" + key);
        return x509Certificate;  
    }  
    public static void main(String[] args) throws Exception {  
        getX509CerCate("F:\\TTF_TEST.cer");  
        
    }   
}
