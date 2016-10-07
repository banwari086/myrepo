package com.sunilos.proj0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.proj0.dao.StudentDAOInt;
import com.sunilos.proj0.dto.StudentDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Student Service. It is transactional, apply delcarative
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

@Service("studentService")
public class StudentServiceSpringImpl implements StudentServiceInt {

	@Autowired
	private StudentDAOInt dao;

	/**
	 * Adds a Student
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(StudentDTO dto) throws DuplicateRecordException {

		StudentDTO dtoExist = dao.findByLogin(dto.getEmail());
		if (dtoExist != null ) {
			throw new DuplicateRecordException("Student Name");
		}
		return dao.add(dto);
	}

	/**
	 * Updates a Student
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated Student is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(StudentDTO dto) throws DuplicateRecordException {
		StudentDTO dtoExist = dao.findByLogin(dto.getEmail());
		// Check if updated Student is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Duplicate Name");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a Student
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
	public StudentDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	/**
	 * Finds Student by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public StudentDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	/**
	 * Searches Students
	 * 
	 * @return list : List of Students
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(StudentDTO dto) {
		return dao.search(dto);
	}

	/**
	 * Searches Students with pagination
	 * 
	 * @return list : List of Students
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
