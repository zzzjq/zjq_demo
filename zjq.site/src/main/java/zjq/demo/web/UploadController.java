//package zjq.demo.web;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import zjq.demo.service.UploadService;
//import zjq.demo.util.ExcelUtil;
//
///**
// * @author:zhangjq
// * @time:2017年12月26日 下午5:14:29
// * @version:v1.0
// */
//@Controller
//@RequestMapping("/upload")
//public class UploadController {
//	
//	@Autowired
//	private UploadService uploadService;
//
//	@RequestMapping("/index")
//	public String uploadIndex(HttpServletRequest request, HttpServletResponse response){
//		return "uploadFile";
//	}
//
//	@RequestMapping(value = "/excel", method = { RequestMethod.POST,
//			RequestMethod.GET })
//	public String uploadExcel(HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestParam("excelFile") MultipartFile excelFile) {
//		List<String[]> list = null;
//		if (excelFile == null)
//			return "fail";
//		try {
//			list = ExcelUtil.readExcel(excelFile);
//		} catch (Exception e) {
//			return "fail";
//		}
//		uploadService.executeInsert(list);
//		return "success";
//	}
//
//}
