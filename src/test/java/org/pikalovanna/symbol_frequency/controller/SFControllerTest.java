package org.pikalovanna.symbol_frequency.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.pikalovanna.symbol_frequency.service.SFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SFControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SFController controller;

    @MockBean
    private SFService service;

    @Test
    void testController() {
        assertThat(controller).isNotNull();
    }

    @Test
    void getSFTestHtmlForm() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"))
                .andExpect(content().string(containsString("Подсчет частоты символов в строке")));
    }

    @Test
    void getSFTestHtmlError() throws Exception {
        mockMvc.perform(post("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(content().string(containsString("Поле не может быть пустым")));
    }
}