package com.easesolutions.service;

import com.easesolutions.model.SkiModel;

public interface SkiCalculationService {
	
	public SkiModel getCalculation(int lowestPoint, int highestPoint, int rowDimension, int colDimension);
	
}