package com.team.tra_e_catch.product;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLogic {
	private final Logger logger = Logger.getLogger(ProductLogic.class);

	@Autowired
	private SqlProdDao sqlProdDao;
}
