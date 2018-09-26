package zjq.test.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import zjq.demo.common.AbstractFactory;
import zjq.demo.exception.BizException;

/**
 * @author:zhangjq
 * @time:2017年4月6日 下午4:57:59
 * @version:v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class MainTest {

	static final private Logger logger = LoggerFactory
			.getLogger(MainTest.class);

	static private AbstractFactory factory = AbstractFactory.getFactory();

	@Test
	public void Jtest() {
		logger.info("zjq.demo.JunitTest-start");
	}

	public int num = 0;

	public void increase() {
		num++;
	}

	@Test
	public void test() throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		while (Thread.activeCount() > 1)
			Thread.yield();
		System.out.println(num);
	}

	public static void main(String[] args) throws Exception{
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
