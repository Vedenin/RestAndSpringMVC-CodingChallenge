package com.github.vedenin.codingchallenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by slava on 16.02.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkUserGetRequest() throws Exception {
        this.mockMvc.perform(get("/rest/user")).andExpect(status().is(401));
        this.mockMvc.perform(get("/rest/user?access_key=sg435jklj")).andExpect(status().isOk());
    }

    @Test
    public void checkErrorGetRequest() throws Exception {
        this.mockMvc.perform(get("/rest/error")).andExpect(status().is(401));
        this.mockMvc.perform(get("/rest/error?access_key=sg435jklj")).andExpect(status().isOk());
    }

    @Test
    public void checkHistoryGetRequest() throws Exception {
        this.mockMvc.perform(get("/rest/history")).andExpect(status().is(401));
        this.mockMvc.perform(get("/rest/history?access_key=sg435jklj")).andExpect(status().isOk());
    }

    @Test
    public void checkPropertyGetRequest() throws Exception {
        this.mockMvc.perform(get("/rest/property")).andExpect(status().is(401));
        this.mockMvc.perform(get("/rest/property?access_key=sg435jklj")).andExpect(status().isOk())
                .andExpect(jsonPath("$['defaultCurrencyTo']").value("USD"))
                .andExpect(jsonPath("$['defaultCurrencyFrom']").value("EUR"))
                .andExpect(jsonPath("$['defaultAmount']").value(1));
    }
}
