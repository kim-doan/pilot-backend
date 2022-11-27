package com.wdyj.boilerplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("local")
class BoilerplateApplicationTests {

	@Autowired
	private DefaultListableBeanFactory dfBean;

	@Test
	void contextLoads() {
		for(String name : dfBean.getBeanDefinitionNames()) {
			System.out.println(" INFO BEAN NAME === " + name);
		}

		return ;
	}

}
