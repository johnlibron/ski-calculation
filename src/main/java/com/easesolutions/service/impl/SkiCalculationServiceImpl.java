package com.easesolutions.service.impl;

import org.springframework.stereotype.Service;

import com.easesolutions.model.TreeNode;
import com.easesolutions.service.SkiCalculationService;
import com.easesolutions.util.Constant;

@Service
public class SkiCalculationServiceImpl implements SkiCalculationService {

	@Override
	public void getCalculation() {
		
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
		
		TreeNode<Integer> root = new TreeNode<Integer>(max);
		
		traverse(map, root, max, rowIndex, colIndex);
	}
	
	private boolean traverse(int[][] map, TreeNode<Integer> root, int startPoint, int row, int col) {
		boolean proceed = false;
		try {
			boolean isNorth = isInMap(row-1, col) && isLessThanStartPoint(map, startPoint, row-1, col);
			boolean isSouth = isInMap(row+1, col) && isLessThanStartPoint(map, startPoint, row+1, col);
			boolean isEast = isInMap(row, col+1) && isLessThanStartPoint(map, startPoint, row, col+1);
			boolean isWest = isInMap(row, col-1) && isLessThanStartPoint(map, startPoint, row, col-1);
			
			proceed = isNorth || isSouth || isEast || isWest;
			
			while (proceed) {
				proceed = addChild(isNorth, root, map, row-1, col, Constant.POSITION.NORTH);
				proceed = addChild(isSouth, root, map, row+1, col, Constant.POSITION.SOUTH);
				proceed = addChild(isEast, root, map, row, col+1, Constant.POSITION.EAST);
				proceed = addChild(isWest, root, map, row, col-1, Constant.POSITION.WEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proceed;
	}

	private boolean addChild(boolean direction, TreeNode<Integer> root, int[][] map, int row, int col, int position) {
		boolean isAdd = false;
		if (direction) {
			TreeNode<Integer> node = null;
			switch (position) {
				case 1:
					node = root.addNorthChild(map[row][col]);
					break;
				case 2:
					node = root.addSouthChild(map[row][col]);
					break;
				case 3:
					node = root.addEastChild(map[row][col]);
					break;
				case 4:
					node = root.addWestChild(map[row][col]);
					break;
			}
			isAdd = traverse(map, node, map[row][col], row, col);
		}
		return isAdd;
	}
	
	private boolean isInMap(int row, int col) {
		return row >= Constant.ZERO && row < Constant.DIMENSION && col >= Constant.ZERO && col < Constant.DIMENSION;
	}
	
	private boolean isLessThanStartPoint(int[][] map, int startPoint, int row, int col) {
		return map[row][col] > Constant.ZERO && map[row][col] < startPoint;
	}
}