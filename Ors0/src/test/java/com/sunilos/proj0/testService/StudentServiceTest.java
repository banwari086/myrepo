package com.sunilos.proj0.testService;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sunilos.proj0.dto.StudentDTO;
import com.sunilos.proj0.service.StudentServiceInt;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispacher-servlet.xml"})
public class StudentServiceTest {
@Autowired 
StudentServiceInt service;
	@Test
	public void testSearch() {
		StudentDTO dto=new StudentDTO();
		dto.setCollegeName("LNCT");
		List<StudentDTO> list = service.search(new StudentDTO(), 1, 5);
		Iterator<StudentDTO>it=list.iterator();
		while(it.hasNext()){
			StudentDTO studentDTO=it.next();
			System.out.println(studentDTO.getFirstName());
		}
		
	}

}
