package com.kkjavatutorials.SpringBootRestApp.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkjavatutorials.SpringBootRestApp.Repo.AuditLogDao;
import com.kkjavatutorials.SpringBootRestApp.Repo.TRSAuditLogDao;
import com.kkjavatutorials.SpringBootRestApp.model.Apple;
import com.kkjavatutorials.SpringBootRestApp.service.AppleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ApplePayTermsController.class})
@WebMvcTest
public class ApplePayTermsControllerTest {

    @InjectMocks
    private ApplePayTermsController applePayTermsController;
    @MockBean
    private AppleService appleService;
    @MockBean
    private AuditLogDao auditLogDao;
    @MockBean
    private TRSAuditLogDao trs;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void saveAppleTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Apple apple = new Apple();
        apple.setId(3L);
        apple.setHeading("Apple Pay Terms");
        apple.setPara("These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites");
        when(appleService.saveApple(any(Apple.class))).thenReturn(apple);
        ResultActions actions = this.mockMvc.perform(post("/saveApple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(apple))).andDo(print())
                .andExpect(status().isCreated());
        MvcResult result = actions.andReturn();
       assertEquals(201, result.getResponse().getStatus());
      // assertEquals("{\"id\":3,\"para\":\"These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites\",\"heading\":\"Apple Pay Terms\"}"
           //    ,result.getResponse().getContentAsString());

    }

    @Test
    public void findAllAppleTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Apple apple = new Apple();
        apple.setId(3L);
        apple.setHeading("Apple Pay Terms");
        apple.setPara("These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites");
        List<Apple> list = new ArrayList<>();
        list.add(apple);
        when(appleService.findAllApples()).thenReturn(list);
        ResultActions actions = this.mockMvc.perform(get("/getall")).andDo(print()).andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200,result.getResponse().getStatus());
      //  assertEquals("[{\"id\":3,\"para\":\"These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites\",\"heading\":\"Apple Pay Terms\"}]"
             //   ,result.getResponse().getContentAsString());

    }

    @Test
    public void getAppleByIdTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Apple apple = new Apple();
        apple.setId(3L);
        apple.setHeading("Apple Pay Terms");
        apple.setPara("These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites");
        when(appleService.getAppleById(anyLong())).thenReturn(apple);
        ResultActions actions = this.mockMvc.perform(post("/get/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(apple))).andDo(print())
                .andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200, result.getResponse().getStatus());
     //   assertEquals("{\"id\":3,\"para\":\"These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites\",\"heading\":\"Apple Pay Terms\"}"
              //  ,result.getResponse().getContentAsString());

    }

    @Test
    public void updateAppleTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Apple apple = new Apple();
        apple.setId(3L);
        apple.setHeading("Apple Pay Terms");
        apple.setPara("These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites");
        when(appleService.updateApple(any(Apple.class))).thenReturn(apple);
        ResultActions actions = this.mockMvc.perform(put("/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(apple)))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200, result.getResponse().getStatus());
       // assertEquals("{\"id\":3,\"para\":\"These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites\",\"heading\":\"Apple Pay Terms\"}"
            //    ,result.getResponse().getContentAsString());

    }

    @Test
    public void deleteAppleTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Apple apple = new Apple();
        apple.setId(3L);
        apple.setHeading("Apple Pay Terms");
        apple.setPara("These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites");
        doNothing().when(appleService).deleteApple(anyLong());
        ResultActions actions = this.mockMvc.perform(delete("/delete/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(apple)))
                .andExpect(status().isNoContent());
        MvcResult result = actions.andReturn();
        assertEquals(204, result.getResponse().getStatus());
        //assertEquals("{\"id\":3,\"heading\":\"Apple Pay Terms\",\"para\":\"These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites\"}"
                //,result.getResponse().getContentAsString());




    }

    @Test
   public void updateByIdTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        Apple apple = new Apple();
        apple.setId(3L);
        apple.setHeading("Apple Pay Terms");
        apple.setPara("These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites");
        when(appleService.updateById(anyLong(),any(Apple.class))).thenReturn(apple);
        ResultActions actions= this.mockMvc.perform(put("/update/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apple)))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200, result.getResponse().getStatus());
      //  assertEquals("{\"id\":3,\"para\":\"These Terms and Condition set forth the rights and obligations of apple and You as they relate to Your use of the Apple Pay Platform to conduct transactions from or through Your websites\",\"heading\":\"Apple Pay Terms\"}",result.getResponse().getContentAsString());



    }






}
