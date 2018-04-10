package com.easesolutions.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easesolutions.exception.CustomException;
import com.easesolutions.model.ResponseModel;
import com.easesolutions.model.SkiModel;
import com.easesolutions.service.SkiCalculationService;

@Controller
public class APIController {
	
	@Autowired
	SkiCalculationService skiCalculationService;

	@RequestMapping(value="/ski-calculation", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel<SkiModel> skiCalculation(HttpServletRequest request) {
		ResponseModel<SkiModel> responseModel = new ResponseModel<>();
		int statusCode = HttpServletResponse.SC_OK;
		String messageCode = "Success";
		SkiModel skiModel = null;
		
		try {
			skiModel = skiCalculationService.getCalculation(0, 10, 4, 4);
		} catch (CustomException e) {
			statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			messageCode = "ERROR";
			skiModel = null;
		}
		
		responseModel.setData(skiModel);
		responseModel.setMessageCode(messageCode);
		responseModel.setStatusCode(statusCode);
		return responseModel;
	}
	
}