package com.sunilos.proj0.service;

import java.util.List;

import com.sunilos.proj0.dto.MarksheetDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;

/**
 * Marksheet Service interface.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface MarksheetServiceInt {

	/**
	 * Adds a Marksheet
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when Marksheet is already exists
	 */
	public long add(MarksheetDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated Marksheet is already exists
	 */
	public void update(MarksheetDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Marksheet
	 * 
	 * @param id
	 */
	public void delete(long id);

	/**
	 * Finds Marksheet by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 */
	public MarksheetDTO findByRollNo(String rollNo);

	/**
	 * Finds Marksheet by primary key
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 */
	public MarksheetDTO findByPK(long id);

	/**
	 * Searches Marksheets
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search Parameters
	 */
	public List search(MarksheetDTO dto);

	/**
	 * Searches Marksheets with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);

	public List getMeritList(int i, int j);

}