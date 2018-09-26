package zjq.demo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author:zhangjq
 * @time:2017年5月4日 下午4:58:17
 * @version:v1.0
 */
@Controller
@RequestMapping("/download")
public class DownloadController {
	
	@RequestMapping("/index")
	public String downloadIndex(HttpServletRequest request,
			HttpServletResponse response){
		return "downloadFile";
	}
	
	//文件下载
	@RequestMapping("/download1")
	public ResponseEntity<byte[]> download1(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		File file = new File("F://好.txt");
		//解决中文乱码问题
		//String fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		InputStream in = new FileInputStream(file);
		byte[] bt = new byte[in.available()];
		in.read(bt);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attchement;filename=" + URLEncoder.encode(file.getName(), "utf-8"));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> entity  = new ResponseEntity<byte[]>(bt, headers, HttpStatus.OK);
		return entity;
	}
	
	//文件下载
	@RequestMapping("/download2")
	public ModelAndView download2(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		InputStream inputStream  = null;
		OutputStream os = null;
		try {
			String fileName = "";
			inputStream = DownloadController.class.getResourceAsStream("/other/BatchPay2AcctTemplate.csv");
			fileName = "BatchPay2AcctTemplate.csv";
			response.setHeader("content-type", "text/html;charset=UTF-8");
			response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));
			response.setBufferSize(1024);        
			os = new BufferedOutputStream(response.getOutputStream());
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(b)) > 0) {
				os.write(b, 0, len);
				os.flush();
			}
			os.close();
			inputStream.close();
			return null;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}finally{
			os = null;
			inputStream = null;
		}
	}

}
