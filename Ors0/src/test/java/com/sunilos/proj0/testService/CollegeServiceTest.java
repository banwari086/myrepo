package com.sunilos.proj0.testService;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sunilos.proj0.dto.CollegeDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.service.CollegeServiceInt;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispacher-servlet.xml"})
public class CollegeServiceTest {
	@Autowired CollegeServiceInt service;
@Test	
public void testAdd() throws DuplicateRecordException{
	CollegeDTO dto=new CollegeDTO();
	dto.setName("Astral");
	dto.setAddress("saver road ujjain");
	dto.setState("mp");
	dto.setCity("Indore");
	dto.setPhoneNo("9786979789");
	service.add(dto);
	System.out.println("success:Test add Success");
	
}
	
}
