package com.github.imvsaurabh.dockertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class
)
@AutoConfigureMockMvc
public class WebControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void greetingTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        assertNotNull(contentAsString);
    }

    @Test
    public void getUsersTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(response.getStatus(), 200);
    }
}
