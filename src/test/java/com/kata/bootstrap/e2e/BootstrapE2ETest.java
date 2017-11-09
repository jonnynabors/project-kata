package com.kata.bootstrap.e2e;

import com.kata.bootstrap.BootstrapApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = BootstrapApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BootstrapE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnListOfVehiclesGivenNoParameters() throws Exception {
        mockMvc.perform(get("/vehicles"))
                .andExpect(jsonPath("$.[0].make").value("Ford"))
                .andExpect(jsonPath("$.[0].model").value("Transit"))
                .andExpect(jsonPath("$.[0].year").value(2007))
                .andExpect(jsonPath("$.[1].make").value("Mercury"))
                .andExpect(jsonPath("$.[1].model").value("Villager"))
                .andExpect(jsonPath("$.[1].year").value(1997));
    }

}
