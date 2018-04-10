package com.easesolutions.controller.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easesolutions.model.ResponseModel;
import com.easesolutions.model.SkiModel;
import com.easesolutions.service.SkiCalculationService;
import com.easesolutions.util.Constant;

@Controller
public class APIController {
	
	@Autowired
	SkiCalculationService skiCalculationService;

	@RequestMapping(value="/ski-calculation", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel<SkiModel> skiCalculation(HttpServletRequest request) throws IOException {
		ResponseModel<SkiModel> responseModel = new ResponseModel<>();
		int statusCode = HttpServletResponse.SC_OK;
		String messageCode = Constant.SUCCESS;
		SkiModel skiModel = null;
		
		try {
			skiModel = skiCalculationService.getCalculation(request.getParameter("filepath"), Constant.LOWEST_POINT, Constant.HIGHEST_POINT, Constant.ROW_DIMENSION, Constant.COL_DIMENSION);
		} catch (Exception e) {
			statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			messageCode = Constant.ERROR;
			skiModel = null;
		}
		
		responseModel.setData(skiModel);
		responseModel.setMessageCode(messageCode);
		responseModel.setStatusCode(statusCode);
		return responseModel;
	}
	
}