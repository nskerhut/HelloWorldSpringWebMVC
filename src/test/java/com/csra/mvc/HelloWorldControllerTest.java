package com.csra.mvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private HelloWorldService service;
	//@Autowired
	//private TestRestTemplate restTemplate;
	
	@Before
	public void setUp() throws Exception {
	}

	//@Autowired
	//private HelloWorldController controller;
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHelloWorld() throws Exception {
		/*assertThat(controller).isNotNull();
		String uri = String.format("http://localhost:%s/HelloWorld",port);
		assertThat(this.restTemplate.getForObject(uri, String.class)).contains("World");
		*/
		when(service.Greet("World")).thenReturn("Hello Mock");
		
		this.mockMvc.perform(get("/HelloWorld"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Mock")));
	}

}
