package com.easesolutions.service.impl;

import org.springframework.stereotype.Service;

import com.easesolutions.service.SkiCalculationService;

@Service
public class SkiCalculationServiceImpl implements SkiCalculationService {

	@Override
	public String getCalculation() {
		
		int[][] map = new int[][]{
			{ 4, 8, 7, 3 },
			{ 2, 5, 9, 3 },
			{ 6, 3, 2, 5 },
			{ 4, 4, 1, 6 }
		};
		
		int max = 0;
		int rowIndex = 0;
		int colIndex = 0;
		
		for (int row = 0; row < map.length; row++) {
			System.out.print(row + " | ");
			for (int col = 0; col < map[row].length; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (max < map[row][col]) {
					max = map[row][col];
					rowIndex = row;
					colIndex = col;
				}
			}
		}
		
		System.out.println();
		System.out.println("max: " + max);
		System.out.println("rowIndex: " + rowIndex);
		System.out.println("colIndex: " + colIndex);
		
		return null;
	}
	
}