package com.easesolutions.model;

import com.easesolutions.util.Constant;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> parent;
	private String axis; 
	private TreeNode<T> north;
	private TreeNode<T> south;
	private TreeNode<T> east;
	private TreeNode<T> west;
	public TreeNode(T data) {
		this.data = data;
		this.parent = null;
		this.axis = Constant.VERTICAL_AXIS;
		this.north = null;
		this.south = null;
		this.east = null;
		this.west = null;
	}
	public TreeNode<T> addNorthChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		childNode.axis = Constant.VERTICAL_AXIS;
		this.north = childNode;
		return childNode;
	}
	public TreeNode<T> addSouthChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		childNode.axis = Constant.VERTICAL_AXIS;
		this.south = childNode;
		return childNode;
	}
	public TreeNode<T> addEastChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		childNode.axis = Constant.HORIZONTAL_AXIS;
		this.east = childNode;
		return childNode;
	}
	public TreeNode<T> addWestChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		childNode.axis = Constant.HORIZONTAL_AXIS;
		this.west = childNode;
		return childNode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TreeNode<T> getParent() {
		return parent;
	}
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}
	public TreeNode<T> getNorth() {
		return north;
	}
	public void setNorth(TreeNode<T> north) {
		this.north = north;
	}
	public TreeNode<T> getSouth() {
		return south;
	}
	public void setSouth(TreeNode<T> south) {
		this.south = south;
	}
	public TreeNode<T> getEast() {
		return east;
	}
	public void setEast(TreeNode<T> east) {
		this.east = east;
	}
	public TreeNode<T> getWest() {
		return west;
	}
	public void setWest(TreeNode<T> west) {
		this.west = west;
	}
}