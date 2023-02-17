/*package com.kkjavatutorials.SpringBootRestApp.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkjavatutorials.SpringBootRestApp.model.AdminLoginModel;
import com.kkjavatutorials.SpringBootRestApp.service.AdminLoginService;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AdminLoginController.class})
@WebMvcTest
public class AdminLoginControllerTest {
    @MockBean
    private AdminLoginService adminLoginService;

    @InjectMocks
    private AdminLoginController adminLoginController;



   // @MockBean
   // private AppleCardService appleCardService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext wac;

    @Test
    public void findAllAdmintest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AdminLoginModel adminLoginModel= new AdminLoginModel();
       adminLoginModel.setId(3L);
       adminLoginModel.setName("mai");
       adminLoginModel.setUsername("Mai@087");
       adminLoginModel.setPassword("mai@0404");
       List<AdminLoginModel> list = new ArrayList<>();
       list.add(adminLoginModel);
       when(adminLoginService.findAllAdmin()).thenReturn(list);
        ResultActions actions=  this.mockMvc.perform(get("/admin")).andDo(print()).andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals( "[{\"id\":3,\"username\":\"Mai@087\",\"password\":\"mai@0404\",\"name\":\"mai\"}]",result.getResponse().getContentAsString());


    }

    @Test
    public void findAdminByIdTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AdminLoginModel adminLoginModel = new AdminLoginModel();
        adminLoginModel.setId(3L);
        adminLoginModel.setName("mai");
        adminLoginModel.setUsername("Mai@087");
        adminLoginModel.setPassword("mai@0404");
        when(adminLoginService.findById(anyLong())).thenReturn(Optional.of(adminLoginModel));
        ResultActions actions = this.mockMvc.perform(post("/admin/id").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(adminLoginModel))).andDo(print())
                .andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("{\"id\":3,\"username\":\"Mai@087\",\"password\":\"mai@0404\",\"name\":\"mai\"}", result.getResponse().getContentAsString());

    }

}*/
