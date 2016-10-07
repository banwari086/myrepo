package com.sunilos.proj0.testService;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispacher-servlet.xml" })
public class RoleServiceTest {
	@Autowired
	RoleServiceInt service;
@Ignore
	public void testSearch() {
		RoleDTO dto = new RoleDTO();
		dto.setName("Student");
		List<RoleDTO> list = service.search(new RoleDTO(), 1,5);
		Iterator<RoleDTO> it = list.iterator();
		while (it.hasNext()) {
			RoleDTO roleDTO = (RoleDTO) it.next();
			System.out.println(roleDTO.getName());
		}
	}

@Test
public void testAdd() throws DuplicateRecordException{
	RoleDTO dto=new RoleDTO();
	dto.setName("stu");
	dto.setDescription("sfdsff");
	dto.setCreatedBy("admin");
	dto.setModifiedBy("admin");
	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	service.add(dto);
	System.out.println("Success : Test Add Success");
}

}
