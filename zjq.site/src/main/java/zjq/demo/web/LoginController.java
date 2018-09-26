package zjq.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zjq.demo.util.IpUtil;

/**
 * @author:zhangjq
 * @time:2018年1月5日 下午1:44:40
 * @version:v1.0
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "/loginIndex", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "login";
	}

	@RequestMapping(value = "/loginMain", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		
		String ip = IpUtil.getRemoteHost(request);
		
		//直接跳转页面
		ModelAndView mv = new ModelAndView("loginSuccess");
		
		//重定向到页面或者资源，浏览器的url发生变化，view里的参数不会带过去，在浏览器输入框以?ip=xxx显示
		//ModelAndView mv = new ModelAndView("redirect:/download/index");
		//ModelAndView mv = new ModelAndView("redirect:index.jsp");
		
		//重定向到页面或者资源，浏览器的url不变，view里的参数会带过去
		//ModelAndView mv = new ModelAndView("forward:/download/index");
		//ModelAndView mv = new ModelAndView("forward:index.jsp");
		
		mv.addObject("ip", ip);
		return mv;
	}
}
