package com.csra.mvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest extends HelloWorldController {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void setUp() throws Exception {
	}

	@Autowired
	private HelloWorldController controller;
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHelloWorld() {
		assertThat(controller).isNotNull();
		String uri = String.format("http://localhost:%s/HelloWorld",port);
		assertThat(this.restTemplate.getForObject(uri, String.class)).contains("World");
		
	}

}
