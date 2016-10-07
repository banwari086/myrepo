package com.sunilos.proj0.rest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunilos.proj0.dto.GenricDTO;
import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.service.RoleServiceInt;

@RestController
public class RoleRESTFullWS {
	@Autowired
	RoleServiceInt service;

	@RequestMapping(value = "/roles/{pageNo}/{pageSize}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getRoleList(@PathVariable("pageNo") int pageNo,
			@PathVariable("pageSize") int pageSize) {
		List dtos = service.search(new RoleDTO(), pageNo, pageSize);
		return dtos;

	}

	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public List<RoleDTO> getRoleList(@RequestBody GenricDTO<RoleDTO> pdto) {
//System.out.println(pdto.getPageNo()+" "+pdto.getPageSize());
		RoleDTO dto=new RoleDTO();
		if(pdto.getDto()!=null){
			dto=pdto.getDto();
		}
		List dtos = service.search(dto, pdto.getPageNo(),
				pdto.getPageSize());

		return dtos;

	}

	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public HashMap addRole(@RequestBody RoleDTO dto) {
		String msg = "";
		boolean success = true;
		try {
			if (dto.getId() > 0) {
				service.update(dto);
				msg = "Role Successfully updated";

			} else {
				service.add(dto);
				msg = "Role Successfully added";
			}
		} catch (DuplicateRecordException e) {
			msg = "Role Already Exist";
			success = false;
		}
		HashMap map = new HashMap();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	}

}
