/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytebistro.weatherservice.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author keith
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

//	@Autowired
//	private WebApplicationContext wac;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldConnect() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Weather Service")));
    }
    @Test
    public void shouldConnectTo() throws Exception {
        this.mockMvc.perform(get("/weather")).andDo(print()).andExpect(status().isOk());

    }
//	@Before
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
//	
//	@Test
//	public void getHome() throws Exception {
//		this.mockMvc.perform(get("/"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
//	}
//	
//	@Test
//	public void postEmptyData() throws Exception {
//		this.mockMvc.perform(post("/"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andExpect(model().attributeHasFieldErrors("formDTO", "messageFromUser"))
//			.andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
//	}
//	
//	@Test
//	public void postSomething() throws Exception {
//		
//		this.mockMvc.perform(post("/").param("messageFromUser", "kikoo"))
//			.andDo(print())
//			.andExpect(status().isMovedTemporarily())
//			.andExpect(model().hasNoErrors())
//			.andExpect(flash().attributeExists("message"))
//			.andExpect(redirectedUrl("/"));
//	}
}
