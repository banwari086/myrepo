package com.sunilos.proj0.service;

import java.util.List;

import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;

/**
 * User Service interface.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface UserServiceInt {

	/**
	 * Adds a User
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when User is already exists
	 */
	public long add(UserDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a User
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated User is already exists
	 */
	public void update(UserDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a User
	 * 
	 * @param id
	 */
	public void delete(long id);

	/**
	 * Finds User by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 */
	public UserDTO findByName(String name);

	/**
	 * Finds User by primary key
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 */
	public UserDTO findByPK(long id);

	/**
	 * Searches Users
	 * 
	 * @return list : List of Users
	 * @param dto
	 *            : Search Parameters
	 */
	public List search(UserDTO dto);

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
	 */
	public List search(UserDTO dto, int pageNo, int pageSize);

	public UserDTO authenticate(UserDTO dto);

	public UserDTO findByLogin(String login);

	public void forgetPassword(String login);

	public void registerUser(UserDTO dto);

	
	
}