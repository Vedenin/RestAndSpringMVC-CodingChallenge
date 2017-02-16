package com.github.vedenin.codingchallenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * Created by slava on 16.02.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MVCServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkGetRegisterRequest() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(model().attributeExists(
                        "countires", "userEntity"
                ));
    }

    @Test
    public void checkPostRegisterRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "2")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void checkDoubleRegisterRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "1")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        )
                .andExpect(status().isOk());

        mockMvc.perform(post("/register")
                .param("userName", "1")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        )
                .andExpect(status().isOk())
                .andExpect(model().attribute("error", "This UserName already used"));

    }

    @Test
    public void checkLoginRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "4")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        ).andExpect(status().isOk());
        mockMvc.perform(post("/login")
                .param("username", "4")
                .param("password", "20")
        ).andExpect(status().isOk());
    }

    @Test
    public void checkConvertCurrentRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "5")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        )
                .andExpect(status().isOk());
        mockMvc.perform(post("/login")
                .param("username", "5")
                .param("password", "20")
        )
                .andExpect(status().isOk());
        mockMvc.perform(post("/converter")
                .param("amount", "100.00")
                .param("from", "RUB")
                .param("to", "EUR")
                .param("type", "current")
                .with(user("5").password("20"))
        )
                .andExpect(status().isOk())
                .andExpect(model().hasNoErrors())
                .andExpect(model().attributeExists(
                        "result", "history"
                ));
    }

    @Test
    public void checkConvertHistoryRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "6")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        ).andExpect(status().isOk());
        mockMvc.perform(post("/login")
                .param("username", "6")
                .param("password", "20")
        ).andExpect(status().isOk());
        mockMvc.perform(post("/converter")
                .param("amount", "100.00")
                .param("from", "RUB")
                .param("to", "EUR")
                .param("type", "history")
                .param("date", "2017-02-16")
                .with(user("6").password("20"))
        )
                .andExpect(status().isOk())
                .andExpect(model().hasNoErrors())
                .andExpect(model().attributeExists(
                        "result", "history"
                ));
    }
}
