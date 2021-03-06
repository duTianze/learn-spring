package com.dutianze.guide.consumeRESTFul;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dutianze.guide.greetRESTFul.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: dutianze
 * Date: 2019-09-19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ConsumeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restRestTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ConsumeController consumeController;

    private URL base;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port);
    }

    /**
     * 测试consumeController被注入
     * @throws Exception
     */
    @Test
    public void contextLoads() {
        assertThat(consumeController).isNotNull();
    }

    /**
     * 测试consumeController被调用
     */
    @Test
    public void consumeShouldReturnDefaultMessage() {
        assertThat(restRestTemplate.getForObject("http://localhost:" + port + "/api/consume", String.class)).contains("success");
    }

    /**
     * mockMvc
     */
    @Test
    public void consumeShouldReturnDefaultMessageV2() throws Exception{
        mockMvc.perform(get("/api/consume")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("success")));
    }

    @Test
    public void getHello() {
        ResponseEntity<Greeting> response = restRestTemplate.getForEntity(base.toString() + "/greeting",
                Greeting.class);
        log.info("statusCode:{}, OK:{}, response:{}", response.getStatusCode(), HttpStatus.OK, response);
        assert response.getStatusCode().equals(HttpStatus.OK);
    }

    @Test
    public void shouldReturnMessage() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting")
                .param("name", "dutianze")
                .contentType(MediaType.TEXT_PLAIN);
        String result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = JSON.parseObject(result);
        assert jsonObject.get("content").equals("Hello, dutianze!");
    }
}