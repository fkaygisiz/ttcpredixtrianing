package com.ge.ttcpredixtraining.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ge.ttcpredixtraining.dao.UserActionsDao;

@RestController
public class UserActionController {

	@Autowired
	private UserActionsDao userActionsDao;

	@RequestMapping("/user-actions")
	public List<String> getUserActions() {
//		List<String> list = new ArrayList<String>(){{
//			add("sadsad");
//			add("bbbb");
//			
//		}};
//		return list;
		return userActionsDao.getUserActions();
	}

	@RequestMapping(value = "/user-actions", method = RequestMethod.POST)
	public void saveUserAction(String action) {
		userActionsDao.saveUserAction(action);
	}
	
	@RequestMapping(value = "/user-actions", method = RequestMethod.DELETE)
	public void deleteUserAction() {
		userActionsDao.deleteUserActions();
	}
}
