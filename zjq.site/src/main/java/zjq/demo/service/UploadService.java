//package zjq.demo.service;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import zjq.demo.dao.PartnerUnionRegMapper;
//import zjq.demo.model.PartnerUnionReg;
//
///**
// * @author:zhangjq
// * @time:2017年12月27日 上午10:19:42
// * @version:v1.0
// */
//@Service
//public class UploadService {
//
//	
//	
//	@Autowired
//	private PartnerUnionRegMapper partnerUnionRegMapper;
//		
//	public void executeInsert(List<String[]> list){
//		ExecutorService executor = Executors.newFixedThreadPool(4);
//		try{
//			for(final String[] str : list){
//				executor.execute(new Runnable() {
//					@Override
//					public void run() {
//						try{
//							PartnerUnionReg partnerUnionReg = new PartnerUnionReg();
//							partnerUnionReg.setName(str[5]);
//							partnerUnionReg.setCardNo(str[6]);
//							partnerUnionReg.setStatus("1");
//							partnerUnionReg.setReqNo(System.currentTimeMillis() + "");
//							partnerUnionReg.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str[1]));
//							partnerUnionRegMapper.insert(partnerUnionReg);
//							System.out.println(Thread.currentThread().getName() + "执行插入" + str[0]);
//						}
//					    catch(Exception e){
//					    	System.out.println(e);
//					    	System.out.println(Thread.currentThread().getName() + "执行插入" + str[0] +"异常,线程死亡");
//					    }
//					}
//				});
//			}
//		}finally{
//			executor.shutdown();
//		}
//	}
//	
//
//}
