package com.ddx.devtests.testboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ddx.devtests.testboot.TestbootnameApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestbootnameApplication.class)
@WebAppConfiguration
public class TestbootnameApplicationTests {

	@Test
	public void contextLoads() {
	}

}
