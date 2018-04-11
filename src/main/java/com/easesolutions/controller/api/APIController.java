package com.easesolutions.controller.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.easesolutions.exception.CustomException;
import com.easesolutions.model.ResponseModel;
import com.easesolutions.model.SkiModel;
import com.easesolutions.service.SkiCalculationService;
import com.easesolutions.util.Constant;

@Controller
public class APIController {
	
	@Autowired
	SkiCalculationService skiCalculationService;

	@RequestMapping(value="/ski-calculation", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel<SkiModel> skiCalculation(@RequestParam("file") MultipartFile file, @RequestParam("lowestPoint") int lowestPoint, @RequestParam("highestPoint") int highestPoint) throws IOException {
		ResponseModel<SkiModel> responseModel = new ResponseModel<>();
		int statusCode = HttpServletResponse.SC_OK;
		String messageCode = Constant.SUCCESS;
		SkiModel skiModel = null;
		
		try {
			skiModel = skiCalculationService.getCalculation(file, lowestPoint, highestPoint);
		} catch (CustomException e) {
			statusCode = e.getErrorCode();
			messageCode = e.getErrorMessage();
			skiModel = null;
		}
		
		responseModel.setData(skiModel);
		responseModel.setMessageCode(messageCode);
		responseModel.setStatusCode(statusCode);
		return responseModel;
	}
}