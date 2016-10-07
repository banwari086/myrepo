package com.sunilos.proj0.testService;



import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.service.UserServiceInt;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispacher-servlet.xml"})
public class UserServiceTest {

	/**
	 * Get the instance of UserService Class
	 */


@Autowired
UserServiceInt service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testAdd() throws DuplicateRecordException {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Rahul");
		dto.setLastName("Sahu");
		dto.setLogin("rahul.Sharma.co.in");
		dto.setPassword("pass1234");
		dto.setRoleId(1l);
		dto.setUnSuccessfulLogin(0);
		dto.setLastLogin(new Timestamp(new Date().getTime()));
		dto.setGender("Male");
		dto.setDob(new Date());
		dto.setLock(dto.INACTIVE);
		dto.setRegisteredIP("192.168.1.16");
		dto.setLastLoginIP("192.168.1.4");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		service.add(dto);

		System.out.println("Success : Test Add Success");
	}
    @Ignore
    public void testRegisterUser(){
    	UserDTO dto=new UserDTO();
    	dto.setFirstName("Arpit");
    	dto.setLastName("tongaria");
    	dto.setLogin("atongaria@gmail.com");
    	dto.setPassword("admin123");
    	dto.setRoleId(1L);
    	dto.setUnSuccessfulLogin(0);
		dto.setLastLogin(new Timestamp(new Date().getTime()));
		dto.setGender("Male");
		dto.setDob(new Date());
		dto.setLock(dto.INACTIVE);
		dto.setRegisteredIP("192.168.1.16");
		dto.setLastLoginIP("192.168.1.4");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		service.registerUser(dto);
		System.out.println("Success :Test Add Success");
    }
    @Test
    public void testSearch(){
    	UserDTO dto=new UserDTO();
    	dto.setFirstName("Akshay");
    	List<UserDTO>list=service.search(new UserDTO(), 1, 5);
    	Iterator<UserDTO> it=list.iterator();
    	
    	while(it.hasNext()){
    		UserDTO userDTO=it.next();
    		System.out.println(userDTO.getFirstName());
    	}
    
    }

}
