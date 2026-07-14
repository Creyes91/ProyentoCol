package com.kristian.proyentocol.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ControladorSumaResta.class)
class ControladorSumaRestaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSumar() throws Exception {
        mockMvc.perform(get("/sumar")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    @Test
    void testRestar() throws Exception {
        mockMvc.perform(get("/restar")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    void testSumarConNegativos() throws Exception {
        mockMvc.perform(get("/sumar")
                        .param("a", "-2")
                        .param("b", "-3"))
                .andExpect(status().isOk())
                .andExpect(content().string("-5"));
    }

    @Test
    void testRestarResultadoNegativo() throws Exception {
        mockMvc.perform(get("/restar")
                        .param("a", "3")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }
}