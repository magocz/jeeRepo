package com.neldam.ejb.service;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.neldam.ejb.entities.User;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
@javax.annotation.security.PermitAll 
public class UserService {

	@PersistenceContext(unitName = "WebApp4Pi")
	EntityManager em;
	
	@Resource
	SessionContext context;

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addNewUser(User user){
		em.merge(user);
	}

}
