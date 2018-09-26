package zjq.demo.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:zhangjq
 * @time:2018年1月15日 下午4:31:01
 * @version:v1.0
 */
@Controller
public class AjaxController {

	@RequestMapping("/ajax/index")
	public String index(){
		return "ajax";
	}
	
	@RequestMapping(value = "/ajax/query", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> query(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, String> result = new HashMap<String, String>();
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		result.put("msg", "123456");
		return result;
	}
	
	/**返回方式，用response.getWriter().write 和 @ResponseBody 效果一样**/
	@RequestMapping(value = "/ajax/query2", method = RequestMethod.POST)
	public void query2(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> result = new HashMap<String, String>();
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		result.put("msg", "123456");
		try {
			response.getWriter().write(result.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
