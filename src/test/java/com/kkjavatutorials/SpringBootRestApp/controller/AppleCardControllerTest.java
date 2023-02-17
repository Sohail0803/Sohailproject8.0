/*package com.kkjavatutorials.SpringBootRestApp.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkjavatutorials.SpringBootRestApp.Repo.AuditLogDao;
import com.kkjavatutorials.SpringBootRestApp.Repo.RelationshipDetailsRepository;
import com.kkjavatutorials.SpringBootRestApp.model.AppleCardModel;
import com.kkjavatutorials.SpringBootRestApp.model.AuditLog;
import com.kkjavatutorials.SpringBootRestApp.model.RelationshipDetails;
import com.kkjavatutorials.SpringBootRestApp.service.AppleCardService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AppleCardController.class})
@WebMvcTest
public class AppleCardControllerTest {
    @MockBean
   private AppleCardService appleCardService;

    @InjectMocks
    private AppleCardController appleCardController;

  //  @MockBean
  // private AppleCardController applec;

    @MockBean
    private AuditLog auditLog;

    @MockBean
    private AuditLogDao auditLogDao;

    @MockBean
    private RelationshipDetailsRepository relationshipDetailsRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext wac;


    @Test
    public void createnew() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        AppleCardModel appleCardModel=  new AppleCardModel();
        appleCardModel.setId(1L);
        appleCardModel.setCardnumber(12345678L);
        appleCardModel.setCardname("MasterCardGold");
        appleCardModel.setDigitized(true);
        appleCardModel.setAgreed(true);
        RelationshipDetails relationshipDetails=new RelationshipDetails();
        relationshipDetails.setId(1L);
        when(relationshipDetailsRepository.findById(anyLong())).thenReturn(Optional.of(relationshipDetails));
        when(appleCardService.saveCard(any(AppleCardModel.class))).thenReturn(appleCardModel);
        ResultActions actions= this.mockMvc.perform(post("/applecards")
                       .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(appleCardModel)))
                .andDo(print())
                .andExpect(status().isCreated());
        MvcResult result = actions.andReturn();
        assertEquals(201, result.getResponse().getStatus());
        assertEquals( "{\"id\":1,\"cardnumber\":12345678,\"cardname\":\"MasterCardGold\",\"agreed\":true,\"digitized\":true}",result.getResponse().getContentAsString());
    }


    @Test
    public void findallCardsTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AppleCardModel appleCardModel=  new AppleCardModel();
        appleCardModel.setId(3L);
        appleCardModel.setCardnumber(12345678L);
        appleCardModel.setCardname("MasterCardGold");
        appleCardModel.setDigitized(true);
        appleCardModel.setAgreed(true);
        List<AppleCardModel> list = new ArrayList<>();
        list.add(appleCardModel);
        when(appleCardService.findAllCard()).thenReturn(list);
       ResultActions actions = this.mockMvc.perform(get("/applecards")).andDo(print()).andExpect(status().isOk());
      MvcResult result= actions.andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("[{\"id\":3,\"cardnumber\":12345678,\"cardname\":\"MasterCardGold\",\"agreed\":true,\"digitized\":true}]",result.getResponse().getContentAsString());

    }
    @Test
    public void findbyIdTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AppleCardModel appleCardModel=  new AppleCardModel();
        appleCardModel.setId(3L);
        appleCardModel.setCardnumber(12345678L);
        appleCardModel.setCardname("MasterCardGold");
        appleCardModel.setDigitized(true);
        appleCardModel.setAgreed(true);
        when(appleCardService.findById(anyLong())).thenReturn(Optional.of(appleCardModel));
        ResultActions actions = this.mockMvc.perform(post("/applecards/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appleCardModel))).andDo(print())
                .andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200,result.getResponse().getStatus());
        assertEquals("{\"id\":3,\"cardnumber\":12345678,\"cardname\":\"MasterCardGold\",\"agreed\":true,\"digitized\":true}",result.getResponse().getContentAsString());

    }

    @Test
    public void deleteCardTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AppleCardModel appleCardModel=  new AppleCardModel();
        appleCardModel.setId(3L);
        appleCardModel.setCardnumber(12345678L);
        appleCardModel.setCardname("MasterCardGold");
        appleCardModel.setDigitized(true);
        appleCardModel.setAgreed(true);
        doNothing().when(appleCardService).deleteCard(anyLong());
        ResultActions actions = this.mockMvc.perform(delete("/applecards/id").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appleCardModel))).andExpect(status().isNoContent());
        MvcResult result = actions.andReturn();
        assertEquals(204,result.getResponse().getStatus());

    }
   @Test
    public void digitizeCardsTest() throws Exception {
       this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
       AppleCardModel appleCardModel=  new AppleCardModel();
       appleCardModel.setId(3L);
       appleCardModel.setCardnumber(12345678L);
       appleCardModel.setCardname("MasterCardGold");
       appleCardModel.setDigitized(true);
       appleCardModel.setAgreed(true);
       when(appleCardService.digitizeCards(anyLong())).thenReturn(appleCardModel);
       ResultActions actions = this.mockMvc.perform(post("/applecards/details/digitize/id")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(appleCardModel))).andDo(print()).andExpect(status().isOk());
       MvcResult result = actions.andReturn();
       assertEquals(200,result.getResponse().getStatus());
       assertEquals("{\"id\":3,\"cardnumber\":12345678,\"cardname\":\"MasterCardGold\",\"agreed\":true,\"digitized\":true}",result.getResponse().getContentAsString());



    }

    @Test
    public void agreeCardsTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AppleCardModel appleCardModel=  new AppleCardModel();
        appleCardModel.setId(3L);
        appleCardModel.setCardnumber(12345678L);
        appleCardModel.setCardname("MasterCardGold");
        appleCardModel.setDigitized(true);
        appleCardModel.setAgreed(true);
        when(appleCardService.agreeCards(anyLong())).thenReturn(appleCardModel);
        ResultActions actions = this.mockMvc.perform(post("/applecards/details/agreed/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appleCardModel))).andDo(print()).andExpect(status().isOk());
        MvcResult result = actions.andReturn();
        assertEquals(200,result.getResponse().getStatus());
        assertEquals("{\"id\":3,\"cardnumber\":12345678,\"cardname\":\"MasterCardGold\",\"agreed\":true,\"digitized\":true}",result.getResponse().getContentAsString());



    }*/







}
