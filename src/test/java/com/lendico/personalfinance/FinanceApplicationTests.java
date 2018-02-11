package com.lendico.personalfinance;

import com.lendico.finance.FinanceApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FinanceApplication.class})
public class FinanceApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

}
