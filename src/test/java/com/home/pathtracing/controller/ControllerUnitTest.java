package com.home.pathtracing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.IOException;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.pathtracing.PathtracingApplication;
import com.home.pathtracing.dto.NavigationPointDto;
import com.home.pathtracing.entity.NavigationPoint;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = PathtracingApplication.class)
@WebAppConfiguration
public class ControllerUnitTest {
	  private MockMvc mvc;
	   @Autowired
	   WebApplicationContext webApplicationContext;
	   
	   @BeforeEach
	   public void setUp() {
		      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   
	   String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   
	    <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	    
	    List<NavigationPointDto> stringToList(String stringJsonArrayResponse) throws JsonParseException, JsonMappingException, IOException{
	   	 ObjectMapper objectMapper = new ObjectMapper();
		 TypeReference<List<NavigationPointDto>> jacksonTypeReference = new TypeReference<List<NavigationPointDto>>() {};
		 return objectMapper.readValue(stringJsonArrayResponse, jacksonTypeReference);
		 
	    }
	   
	   
	   @Test
	   @DisplayName("Test 1:Display Starting coordinate which is inserted using data.sql during application start up")
	   @Order(1)
	   public void displayStartCoordinateTest()  throws Exception{
		  
		   //Action
		    String uri = "/trace/startpoint";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			String stringResponse = mvcResult.getResponse().getContentAsString();
			NavigationPoint navigationPoint  = mapFromJson(stringResponse, NavigationPoint.class);
			
			
			//Verify
			 assertEquals(200, status);
			 assertEquals(1, navigationPoint.getId());
			 assertEquals(10, navigationPoint.getXCoordinate());
			 assertEquals(20, navigationPoint.getYCoordinate());
			 			 			   
	   }
	   
	   
	   
	   @Test
	   @DisplayName("Test 2:Move 2 steps right ")
	   @Order(2)
	   public void moveRightTest()  throws Exception{
		  
		   //Action
		    String uri = "/trace/moveright/2";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			String stringResponse = mvcResult.getResponse().getContentAsString();
			NavigationPoint navigationPoint  = mapFromJson(stringResponse, NavigationPoint.class);
			
			
			//Verify
			 assertEquals(201, status);
			 assertEquals(2, navigationPoint.getId());
			 assertEquals(12, navigationPoint.getXCoordinate());
			 assertEquals(20, navigationPoint.getYCoordinate());
			 			 			   
	   }
	   
	   @Test
	   @DisplayName("Test 3:Move up 4 steps")
	   @Order(3)
	   public void moveUpTest()  throws Exception{
		  
		   //Action
		    String uri = "/trace/moveup/4";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			String stringResponse = mvcResult.getResponse().getContentAsString();
			NavigationPoint navigationPoint  = mapFromJson(stringResponse, NavigationPoint.class);
			
			
			//Verify
			 assertEquals(201, status);
			 assertEquals(3, navigationPoint.getId());
			 assertEquals(12, navigationPoint.getXCoordinate());
			 assertEquals(24, navigationPoint.getYCoordinate());
			 			 			   
	   }
	   
	   
	   @Test
	   @DisplayName("Test 4:Move left 5 steps")
	   @Order(4)
	   public void moveLeftTest()  throws Exception{
		  
		   //Action
		    String uri = "/trace/moveleft/5";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			String stringResponse = mvcResult.getResponse().getContentAsString();
			NavigationPoint navigationPoint  = mapFromJson(stringResponse, NavigationPoint.class);
			
			
			//Verify
			 assertEquals(201, status);
			 assertEquals(4, navigationPoint.getId());
			 assertEquals(7, navigationPoint.getXCoordinate());
			 assertEquals(24, navigationPoint.getYCoordinate());
			 			 			   
	   }
	   
	   @Test
	   @DisplayName("Test 5:Move down 10 steps")
	   @Order(5)
	   public void moveDownTest()  throws Exception{
		  
		   //Action
		    String uri = "/trace/movedown/10";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			String stringResponse = mvcResult.getResponse().getContentAsString();
			NavigationPoint navigationPoint  = mapFromJson(stringResponse, NavigationPoint.class);
			
			
			//Verify
			 assertEquals(201, status);
			 assertEquals(5, navigationPoint.getId());
			 assertEquals(7, navigationPoint.getXCoordinate());
			 assertEquals(14, navigationPoint.getYCoordinate());
			 			 			   
	   }
	   
	   
	   @Test
	   @DisplayName("Test 6:Display all navigated test")
	   @Order(6)
	   public void displayAllNavigatedCoordinateTest()  throws Exception{
		  
		   //Action
		    String uri = "/trace/show";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			String stringResponse = mvcResult.getResponse().getContentAsString();
			

			 List<NavigationPointDto> navigationPoints=stringToList(stringResponse);
			
			
			//Verify
			 navigationPoints.forEach(e -> System.out.println(e.getXCoordinate()+" "+e.getYCoordinate()));
			 assertEquals(200, status);
			 assertEquals(5,navigationPoints.size() );

			 			 			   
	   }

}
