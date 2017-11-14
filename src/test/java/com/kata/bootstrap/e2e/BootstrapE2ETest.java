package com.kata.bootstrap.e2e;

import com.kata.bootstrap.BootstrapApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BootstrapApplication.class)
@AutoConfigureMockMvc
public class BootstrapE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnListOfVehicles() {
        mockMvc.perform(get("/vehicles"))
                .andExpect(jsonPath("$.[0].make").value())
                .andExpect(jsonPath("$.[0].model").value())
                .andExpect(jsonPath("$.[1].make").value())
                .andExpect(jsonPath("$.[1].model").value());
    }
}
