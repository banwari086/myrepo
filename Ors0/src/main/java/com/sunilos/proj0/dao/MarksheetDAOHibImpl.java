package com.sunilos.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunilos.proj0.dto.MarksheetDTO;
import com.sunilos.proj0.exception.DatabaseException;

/**
 * Hibernate implementation of Marksheet DAO.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Repository("marksheetDAO")
public class MarksheetDAOHibImpl implements MarksheetDAOInt {

	private static Logger log = Logger.getLogger(MarksheetDAOHibImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Adds a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public long add(MarksheetDTO dto) {

		log.debug("DAO add Started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */

	public void update(MarksheetDTO dto) {
		log.debug("DAO update Started");
		sessionFactory.getCurrentSession().update(dto);
	}

	/**
	 * Deletes a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */

	public void delete(long id) {
		log.debug("DAO delete Started");
		MarksheetDTO dto = new MarksheetDTO();
		dto.setId(id);
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Marksheet by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */

	public MarksheetDTO findByPK(long pk) {

		Session session = sessionFactory.getCurrentSession();
		MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, pk);
		session.evict(dto);
		return dto;
	}

	/**
	 * Finds Marksheet by Name
	 * 
	 * @param rollNo
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */

	public MarksheetDTO findByRollNo(String rollNo) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MarksheetDTO.class).add(
				Restrictions.eq("rollNo", rollNo));
		List list = criteria.list();

		MarksheetDTO dto = null;
		if (list.size() == 1) {
			dto = (MarksheetDTO) list.get(0);
			session.evict(dto);
		}

		return dto;
	}

	/**
	 * Searches Marksheets
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */

	public List search(MarksheetDTO dto) {
		return search(dto, 0, 0);
	}

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
	 * @throws DatabaseException
	 */

	public List search(MarksheetDTO dto, int pageNo, int pageSize) {

		log.debug("DAO search Started");

		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				MarksheetDTO.class);

		
		if (dto.getId() > 0) {
			c.add(Restrictions.eq("id", dto.getId()));
		}
		if (dto.getRollNo() != null && dto.getRollNo().length() > 0) {
			c.add(Restrictions.like("rollNo", dto.getRollNo()));
		}
		if (dto.getName() != null && dto.getName().length() > 0) {
			c.add(Restrictions.like("name", dto.getName() + "%"));
		}
		if (dto.getPhysics() != null && dto.getPhysics() > 0) {
			c.add(Restrictions.eq("physics", dto.getPhysics()));
		}
		if (dto.getChemistry() != null && dto.getChemistry() > 0) {
			c.add(Restrictions.eq("chemistry", dto.getChemistry()));
		}
		if (dto.getMaths() != null && dto.getMaths() > 0) {
			c.add(Restrictions.eq("maths", dto.getMaths()));
		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			c.setFirstResult(((pageNo - 1) * pageSize));
			c.setMaxResults(pageSize);
		}
		return c.list();
	}

	
	public List getMeritList(int pageNo, int pageSize) {
		String hql = "from MarksheetDTO order by (physics + chemistry + maths) desc";
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery(hql);
		q.setFirstResult((pageNo - 1) * pageSize);
		q.setMaxResults(pageSize);
        return q.list();

		
		
		
	}

}
