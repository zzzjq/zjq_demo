package zjq.test.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author:zhangjq
 * @time:2017年4月6日 下午4:57:59
 * @version:v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class MainTest {

	@Test
	public void Jtest() {
		System.out.println("zjq.demo.JunitTest-start");
	}

	public static void main(String[] args) {
		System.out.println(16 % 16);
	}

}
