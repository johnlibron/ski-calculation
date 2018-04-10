package com.easesolutions.model;

public class PathModel {
	private int data;
	private int row;
	private int col;
	private String axis;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}
	@Override
	public String toString() {
		return "PathModel [data=" + data + ", row=" + row + ", col=" + col + ", axis=" + axis + "]";
	}
}