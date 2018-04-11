package com.easesolutions.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.easesolutions.model.SkiModel;

public interface SkiCalculationService {
	
	public SkiModel getCalculation(MultipartFile file, int lowestPoint, int highestPoint) throws IOException;
	
}