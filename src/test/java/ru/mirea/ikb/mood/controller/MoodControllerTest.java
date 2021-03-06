package ru.mirea.ikb.mood.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.mirea.ikb.mood.Application;
import ru.mirea.ikb.mood.repository.MoodRepository;

import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(Application.class)
class MoodControllerTest {

    MockMvc mockMvc;

    @Autowired
    MoodRepository moodRepository;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void testMain() throws Exception {
        mockMvc.perform(get("/main")).andExpect(status().isOk());
    }

    @Test
    void testPlaylists() throws Exception {
        Collection<String> allMoods = moodRepository.findAllMoods();
        Assertions.assertNotNull(allMoods);

        String firstMood = allMoods.stream().findFirst().orElse("NotFound");
        Assertions.assertTrue(moodRepository.playlists(firstMood).isPresent());

        Assertions.assertFalse(moodRepository.playlists("Missing").isPresent());
    }
}