package com.sunilos.proj0.service;

import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.proj0.dao.UserDAOInt;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.util.EmailBuilder;

/**
 * Session facade of User Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Service("userService")
public class UserServiceSpringImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao;
   @Autowired
   private JavaMailSenderImpl mailSender;
	/**
	 * Adds a User
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws DuplicateRecordException {

		UserDTO dtoExist = dao.findByLogin(dto.getLogin());
		if (dtoExist != null) {
			throw new DuplicateRecordException("User Name");
		}
		return dao.add(dto);
	}

	/**
	 * Updates a User
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated User is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto) throws DuplicateRecordException {
		UserDTO dtoExist = dao.findByLogin(dto.getLogin());
		// Check if updated User is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Name");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a User
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	/**
	 * Finds record by Primary Key
	 */
	@Transactional(readOnly = true)
	public UserDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	/**
	 * Finds User by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public UserDTO findByName(String name) {
		return dao.findByName(name);
	}

	/**
	 * Searches Users
	 * 
	 * @return list : List of Users
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		return dao.search(dto);
	}

	/**
	 * Searches Users with pagination
	 * 
	 * @return list : List of Users
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDTO authenticate(UserDTO dto) {
		
		return dao.authenticate(dto.getLogin(), dto.getPassword());
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		
		return dao.findByLogin(login);
	}

	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void registerUser(UserDTO dto) {
		
		dao.registerUser(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void forgetPassword(String login) {
		 UserDTO userData = findByLogin(login);
	        boolean flag = false;
	System.out.println(login);
	        if (userData == null) {
	            /*throw new RecordNotFoundException("Email Id Does not matched.");*/

	        }

	        HashMap<String, String> map = new HashMap<String, String>();
	        map.put("login", userData.getLogin());
	        map.put("password", userData.getPassword());
	        map.put("firstName", userData.getFirstName());
	        map.put("lastName", userData.getLastName());
	        String message = EmailBuilder.getForgetPasswordMessage(map);
	        MimeMessage msg= mailSender.createMimeMessage();
	        MimeMessageHelper helper;
	        try {
				helper=new MimeMessageHelper(msg,true);
				 helper.setSubject("SUNARYS ORS Password reset");
			        helper.setText(message, true);
			        
			        mailSender.send(msg);
			        flag = true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	        
	          /*return flag;*/
	    

		
	}

	
     
	

	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void registerUser(UserDTO dto) {
		
	
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("login", dto.getLogin());
		map.put("password", dto.getPassword());
		String message=EmailBuilder.getUserRegistrationMessage(map);
		
		MimeMessage msg=mailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		try {
			helper=new MimeMessageHelper(msg,true);
			
			helper.setTo(dto.getLogin());
			helper.setSubject("Registration is successful for ORS Project SUNRAYS Technologies");
			helper.setText(message,true);
			mailSender.send(msg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}*/

}
