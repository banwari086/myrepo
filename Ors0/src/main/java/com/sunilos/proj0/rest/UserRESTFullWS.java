package com.sunilos.proj0.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.service.UserServiceInt;

@RestController

public class UserRESTFullWS {

	@Autowired
	UserServiceInt service;

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody UserDTO dto)
			throws DuplicateRecordException {
		System.out.println("Creating User " + dto.getFirstName());
		String msg = "User Has been Created";
		

		service.add(dto);

		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setLocation(ucBuilder
		 * .path("/user/{id}").buildAndExpand(user.getId()).toUri());
		 */
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UserDTO> getUsers() {
		List<UserDTO> dtos = service.search(new UserDTO());
		return dtos;

	}
}