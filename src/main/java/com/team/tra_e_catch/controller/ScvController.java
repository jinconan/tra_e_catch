package com.team.tra_e_catch.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.tra_e_catch.scv.ScvLogic;

@Controller
public class ScvController {

	private static final Logger logger = Logger.getLogger(ScvController.class);

	@Autowired
	private ScvLogic scvLogic;
	
	/**
	 * �α��� ó�� ��û �޼ҵ�
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/login", method = RequestMethod.POST)
	public String login(Model mod) {
		logger.info("login");
		return "home";
	}

	/**
	 * �α��� ������ ��û �޼ҵ�
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/view/login", method = RequestMethod.GET)
	public String viewLogin(Model mod) {
		logger.info("viewLogin");
		return "scv/login";
	}

	/**
	 * �α׾ƿ� ó�� ��û �޼ҵ�
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/logout", method = RequestMethod.GET)
	public String logout(Model mod) {
		logger.info("logout");
		return "home";
	}

	/**
	 * ���� ���� ó�� ��û �޼ҵ�
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/modify", method = RequestMethod.POST)
	public String modify(Model mod) {
		logger.info("modify");
		return "scv/modify";
	}

	/**
	 * ���� ���� ������ ��û �޼ҵ�
	 * @param mod
	 * @return
	 */
	@RequestMapping(value = "/scv/view/modify", method = RequestMethod.GET)
	public String viewModify(Model mod) {
		logger.info("viewModify");
		return "scv/modify";
	}

}
