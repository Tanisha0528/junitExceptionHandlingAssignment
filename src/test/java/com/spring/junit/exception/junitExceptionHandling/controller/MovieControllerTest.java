package com.spring.junit.exception.junitExceptionHandling.controller;

import com.spring.junit.exception.junitExceptionHandling.JunitExceptionHandlingAssignmentApplication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JunitExceptionHandlingAssignmentApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieControllerTest {

    //for controller based mocks
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext employeeContext;//autowired the configuration

    @Before
    public void setup()
    {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(employeeContext).build();
    }
    @Test
    public void verifyAllMovies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/getAllMovies")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andDo(print());

        ;
    }    @Test
    public void verifyMovieById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/getMovieById/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.rating").exists())
                .andExpect(jsonPath("$.genre").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Maverick"))
                .andDo(print());


    }
   @Test
    public void verifyValidMovie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/abcdefgh")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.message").value("request can't be placed due to malfunctioned syntax"));


    }



}
