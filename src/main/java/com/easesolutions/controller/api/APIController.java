package com.easesolutions.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easesolutions.service.SkiCalculationService;

@Controller
public class APIController {
	
	@Autowired
	SkiCalculationService skiCalculationService;

	@RequestMapping(value="/ski-calculation", method=RequestMethod.GET)
	@ResponseBody
	public String SkiCalculation() {
		skiCalculationService.getCalculation();
		return null;
	}
	
}