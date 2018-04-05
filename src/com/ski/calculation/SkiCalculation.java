package com.ski.calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkiCalculation {
	public static void main(String[] args) {

		Map<String, Integer> northMap = new HashMap<>();
		Map<String, Integer> southMap = new HashMap<>();
		Map<String, Integer> eastMap = new HashMap<>();
		Map<String, Integer> westMap = new HashMap<>();
		
		int max = 0;
		
		int[][] map = new int[][]{
			{ 4, 8, 7, 3 },
			{ 2, 5, 9, 3 },
			{ 6, 3, 2, 5 },
			{ 4, 4, 1, 6 }
		};
		
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
					if (row-1 >= 0 && row-1 <= map.length-1) {
						northMap.put("value", map[row-1][col]);
						northMap.put("row", row-1);
						northMap.put("col", col);
					} else {
						northMap.put("value", 0);
						northMap.put("row", 0);
						northMap.put("col", 0);
					}
					if (row+1 >= 0 && row+1 <= map.length-1) {
						southMap.put("value", map[row+1][col]);
						southMap.put("row", row+1);
						southMap.put("col", col);
					} else {
						southMap.put("value", 0);
						southMap.put("row", 0);
						southMap.put("col", 0);
					}
					if (col+1 >= 0 && col+1 <= map[row].length-1) {
						eastMap.put("value", map[row][col+1]);
						eastMap.put("row", row);
						eastMap.put("col", col+1);
					} else {
						eastMap.put("value", 0);
						eastMap.put("row", 0);
						eastMap.put("col", 0);
					}
					if (col-1 >= 0 && col-1 <= map[row].length-1) {
						westMap.put("value", map[row][col-1]);
						westMap.put("row", row);
						westMap.put("col", col-1);
					} else {
						westMap.put("value", 0);
						westMap.put("row", 0);
						westMap.put("col", 0);
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("max: " + max);
		System.out.println("[north] value: " + northMap.get("value") + ", row: " + northMap.get("row") + ", col: " + northMap.get("col"));
		System.out.println("[south] value: " + southMap.get("value") + ", row: " + southMap.get("row") + ", col: " + southMap.get("col"));
		System.out.println("[east] value: " + eastMap.get("value") + ", row: " + eastMap.get("row") + ", col: " + eastMap.get("col"));
		System.out.println("[west] value: " + westMap.get("value") + ", row: " + westMap.get("row") + ", col: " + westMap.get("col"));
		
		int min = max;
		
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (min > map[row][col]) {
					min = map[row][col];
					if (row-1 >= 0 && row-1 <= map.length-1) {
						northMap.put("value", map[row-1][col]);
						northMap.put("row", row-1);
						northMap.put("col", col);
					} else {
						northMap.put("value", 0);
						northMap.put("row", 0);
						northMap.put("col", 0);
					}
					if (row+1 >= 0 && row+1 <= map.length-1) {
						southMap.put("value", map[row+1][col]);
						southMap.put("row", row+1);
						southMap.put("col", col);
					} else {
						southMap.put("value", 0);
						southMap.put("row", 0);
						southMap.put("col", 0);
					}
					if (col+1 >= 0 && col+1 <= map[row].length-1) {
						eastMap.put("value", map[row][col+1]);
						eastMap.put("row", row);
						eastMap.put("col", col+1);
					} else {
						eastMap.put("value", 0);
						eastMap.put("row", 0);
						eastMap.put("col", 0);
					}
					if (col-1 >= 0 && col-1 <= map[row].length-1) {
						westMap.put("value", map[row][col-1]);
						westMap.put("row", row);
						westMap.put("col", col-1);
					} else {
						westMap.put("value", 0);
						westMap.put("row", 0);
						westMap.put("col", 0);
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("min: " + min);
		System.out.println("[north] value: " + northMap.get("value") + ", row: " + northMap.get("row") + ", col: " + northMap.get("col"));
		System.out.println("[south] value: " + southMap.get("value") + ", row: " + southMap.get("row") + ", col: " + southMap.get("col"));
		System.out.println("[east] value: " + eastMap.get("value") + ", row: " + eastMap.get("row") + ", col: " + eastMap.get("col"));
		System.out.println("[west] value: " + westMap.get("value") + ", row: " + westMap.get("row") + ", col: " + westMap.get("col"));
	}
}