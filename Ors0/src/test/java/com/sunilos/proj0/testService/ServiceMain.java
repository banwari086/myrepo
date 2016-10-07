package com.sunilos.proj0.testService;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.service.UserServiceInt;

public class ServiceMain {

	public static void main(String[] args) throws DuplicateRecordException {
		testAdd();
	}
	
	public static void testAdd() throws DuplicateRecordException {
		
		
		//ApplicationContext apx=new float;
		ApplicationContext apx=new
		FileSystemXmlApplicationContext("I:/MyWork/Ors0/src/main/webapp/WEB-INF/dispacher-servlet.xml");

	UserServiceInt service = (UserServiceInt) apx.getBean("userService");
		UserDTO dto = new UserDTO();
		dto.setFirstName("Rahul");
		dto.setLastName("Sahu");
		dto.setLogin("rahul.sahu@sunrays.co.in");
		dto.setPassword("pass1234");
		dto.setRoleId(1l);
		dto.setUnSuccessfulLogin(0);
		dto.setLastLogin(new Timestamp(new Date().getTime()));
		dto.setGender("Male");
		dto.setDob(new Date());
		//dto.setLock(dto.INACTIVE);
		dto.setRegisteredIP("192.168.1.16");
		dto.setLastLoginIP("192.168.1.4");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		service.add(dto);

		System.out.println("Success : Test Add Success");
	}

}
