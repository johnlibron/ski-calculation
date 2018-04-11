package com.easesolutions.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.easesolutions.model.PathModel;
import com.easesolutions.model.SkiModel;
import com.easesolutions.model.TreeNode;
import com.easesolutions.service.SkiCalculationService;
import com.easesolutions.util.Constant;

@Service
public class SkiCalculationServiceImpl implements SkiCalculationService {
	
	private List<List<PathModel>> gbPossiblePaths;
	private int gbLowestPoint;
	private int gbHighestPoint;
	private int gbRowDimension;
	private int gbColDimension;

	@Override
	public SkiModel getCalculation(String filepath, int lowestPoint, int highestPoint) throws IOException {
		gbLowestPoint = lowestPoint;
		gbHighestPoint = highestPoint;
		
		int[][] map = getMap(filepath);
		
		List<PathModel> highestTenPoints = getHighestPoints(map);
		
		List<SkiModel> possiblePaths = getPossiblePaths(map, highestTenPoints);

		SkiModel skiModel = getCalculatedPath(possiblePaths);
		
		return skiModel;
	}
	
	private int[][] getMap(String filepath) throws IOException {
		int[][] map = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(filepath);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			int row = Constant.ZERO;
	        while((line = bufferedReader.readLine()) != null) {
	        	if (row == Constant.ZERO) {
	        		String[] dimensions = line.split(Constant.MAP_CHARACTER_SPLIT);
	        		gbRowDimension = Integer.parseInt(dimensions[0]);
	        		gbColDimension = Integer.parseInt(dimensions[1]);
	        		map = new int[gbRowDimension][gbColDimension];
	        	} else {
	        		String[] rowPoints = line.split(Constant.MAP_CHARACTER_SPLIT);
		            for (int col = 0; col < rowPoints.length; col++) {
		            	map[row-1][col] = Integer.parseInt(rowPoints[col]);
		            }
	        	}
	        	row++;
	        }
		} catch(Exception e) {
			throw e;
		} finally {
			bufferedReader.close();
			fileReader.close();
		}
		return map;
	}
	
	private List<PathModel> getHighestPoints(int[][] map) {
		List<PathModel> highestTenPoints = new ArrayList<>();
		PathModel pathModel = null;
		int highestPoint = gbHighestPoint;
		if (map.length == gbRowDimension) {
			while (highestTenPoints.size() <= gbRowDimension) {
				for (int row = 0; row < map.length; row++) {
					if (map[row].length == gbColDimension) {
						for (int col = 0; col < map[row].length; col++) {
							if (highestPoint == map[row][col]) {
								pathModel = new PathModel();
								pathModel.setData(map[row][col]);
								pathModel.setRow(row);
								pathModel.setCol(col);
								highestTenPoints.add(pathModel);
							}
						}
					} else {
						// throw exception
					}
				}
				highestPoint--;
			}
		} else {
			// throw exception
		}
		return highestTenPoints;
	}

	private List<SkiModel> getPossiblePaths(int[][] map, List<PathModel> getHighestTenPoints) {
		List<SkiModel> possiblePaths = new ArrayList<>();
		for (PathModel pathModel : getHighestTenPoints) {
			gbPossiblePaths = new ArrayList<>();
			
			TreeNode<Integer> root = new TreeNode<Integer>(pathModel.getData());
			
			createPathTree(map, root, pathModel);
			
			traversePathTree(root, new ArrayList<PathModel>(), 0);
			
			Collections.sort(gbPossiblePaths, new Comparator<List<PathModel>>() {
				@Override
				public int compare(List<PathModel> l1, List<PathModel> l2) {
					Integer s1 = l1.size();
					Integer s2 = l2.size();
					Integer sr = s2.compareTo(s1);
					if (sr == Constant.ZERO) {
						for (int i = 0; i < l1.size(); i++) {
							Integer d1 = l1.get(i).getData();
							Integer d2 = l2.get(i).getData();
							Integer dr = d2.compareTo(d1);
							if (dr != Constant.ZERO) {
								return dr;
							}
						}
					}
					return sr;
				}
			});
			
			List<Integer> pathList = new ArrayList<>();
			List<String> axisList = new ArrayList<>();
			
			for (PathModel pm : gbPossiblePaths.get(0)) {
				pathList.add(pm.getData());
				axisList.add(pm.getAxis());
			}
			
			SkiModel skiModel = new SkiModel();
			skiModel.setPath(pathList);
			skiModel.setAxis(axisList);
			skiModel.setLengthPath(pathList.size());
			skiModel.setDropPath(pathList.get(0) - pathList.get(pathList.size()-1));
			
			possiblePaths.add(skiModel);
		}
		return possiblePaths;
	}

	private SkiModel getCalculatedPath(List<SkiModel> possiblePaths) {
		SkiModel path = new SkiModel();
		for (SkiModel skiModel : possiblePaths) {
			
			int pathVerticalDrop = Constant.ZERO;
			int skiModelVerticalDrop = Constant.ZERO;

			if (null == path.getLengthPath() && null == path.getLengthPath() && null == path.getLengthPath() && null == path.getLengthPath()) {
				path.setLengthPath(skiModel.getLengthPath());
				path.setAxis(skiModel.getAxis());
				path.setPath(skiModel.getPath());
				path.setDropPath(skiModel.getDropPath());
			} else {
				if (skiModel.getLengthPath() > path.getLengthPath()) {
					path.setLengthPath(skiModel.getLengthPath());
					path.setAxis(skiModel.getAxis());
					path.setPath(skiModel.getPath());
					path.setDropPath(skiModel.getDropPath());
				} else if (skiModel.getLengthPath() == path.getLengthPath()) {
					for (int i = 0; i < path.getPath().size(); i++) {
						if ((i+1) < path.getPath().size()) {
							if (path.getPath().get(i).equals(Constant.VERTICAL_AXIS) && path.getPath().get(i+1).equals(Constant.VERTICAL_AXIS)) {
								pathVerticalDrop++;
							}
						}
					}
					
					for (int i = 0; i < skiModel.getPath().size(); i++) {
						if ((i+1) < skiModel.getPath().size()) {
							if (skiModel.getPath().get(i).equals(Constant.VERTICAL_AXIS) && skiModel.getPath().get(i+1).equals(Constant.VERTICAL_AXIS)) {
								skiModelVerticalDrop++;
							}
						}
					}
					
					if (skiModelVerticalDrop > pathVerticalDrop) {
						path.setAxis(skiModel.getAxis());
						path.setPath(skiModel.getPath());
					}
					
					if (skiModel.getDropPath() > path.getDropPath()) {
						path.setDropPath(skiModel.getDropPath());
					}
				}
			}
		}
		return path;
	}
	
	private boolean createPathTree(int[][] map, TreeNode<Integer> root, PathModel pathModel) {
		int startPoint = pathModel.getData();
		int row = pathModel.getRow();
		int col = pathModel.getCol();
		boolean proceed = false;
		try {
			boolean isNorth = isInMap(row-1, col) && isLessThanStartPoint(map, row-1, col, startPoint);
			boolean isSouth = isInMap(row+1, col) && isLessThanStartPoint(map, row+1, col, startPoint);
			boolean isEast = isInMap(row, col+1) && isLessThanStartPoint(map, row, col+1, startPoint);
			boolean isWest = isInMap(row, col-1) && isLessThanStartPoint(map, row, col-1, startPoint);
			
			proceed = isNorth || isSouth || isEast || isWest;
			
			if (proceed) {
				proceed = addTreeNode(isNorth, root, map, row-1, col, Constant.POSITION.NORTH);
				proceed = addTreeNode(isSouth, root, map, row+1, col, Constant.POSITION.SOUTH);
				proceed = addTreeNode(isEast, root, map, row, col+1, Constant.POSITION.EAST);
				proceed = addTreeNode(isWest, root, map, row, col-1, Constant.POSITION.WEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proceed;
	}

	private boolean addTreeNode(boolean proceed, TreeNode<Integer> root, int[][] map, int row, int col, int position) {
		boolean isAdd = false;
		if (proceed) {
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
			PathModel pathModel = new PathModel();
			pathModel.setData(map[row][col]);
			pathModel.setRow(row);
			pathModel.setCol(col);
			isAdd = createPathTree(map, node, pathModel);
		}
		return isAdd;
	}
	
	private boolean isInMap(int row, int col) {
		return row >= Constant.ZERO && row < gbRowDimension && col >= Constant.ZERO && col < gbColDimension;
	}
	
	private boolean isLessThanStartPoint(int[][] map, int row, int col, int startPoint) {
		return map[row][col] >= gbLowestPoint && map[row][col] <= gbHighestPoint && map[row][col] < startPoint;
	}
	
	private void traversePathTree(TreeNode<Integer> node, List<PathModel> path, int pathLength) {
		if (null == node) {
			return;
		}
		PathModel pathModel = new PathModel();
		pathModel.setData(node.getData());
		pathModel.setAxis(node.getAxis());
		path.add(pathLength, pathModel);
		pathLength++;
		if (null == node.getNorth() && null == node.getSouth() && null == node.getEast() && null == node.getWest()) {
			getPossiblePathInPathTree(path, pathLength);
		} else {
			traversePathTree(node.getNorth(), path, pathLength);
			traversePathTree(node.getSouth(), path, pathLength);
			traversePathTree(node.getEast(), path, pathLength);
			traversePathTree(node.getWest(), path, pathLength);
		}
    }
	
	private void getPossiblePathInPathTree(List<PathModel> path, int pathLength) {
		List<PathModel> pathList = new ArrayList<>();
		for (int i = 0; i < pathLength; i++) {
			PathModel pathModel = path.get(i);
			pathList.add(pathModel);
		}
		gbPossiblePaths.add(pathList);
	}
	
}