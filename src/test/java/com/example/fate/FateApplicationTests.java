package com.example.fate;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.fate.dto.servent.Servent;
import com.example.fate.dto.servent.ServentConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=ServentConfig.class)
public class FateApplicationTests {

    @Autowired
    private Servent saber;
	@Test
	public void contextLoads() {
	    assertNotNull(saber);
	}

}
