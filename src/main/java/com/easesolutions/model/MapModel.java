package com.easesolutions.model;

public class MapModel {
	private int number;
	private int row;
	private int col;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	@Override
	public String toString() {
		return "MapModel [number=" + number + ", row=" + row + ", col=" + col + "]";
	}
}