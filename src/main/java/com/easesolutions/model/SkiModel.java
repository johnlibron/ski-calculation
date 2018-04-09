package com.easesolutions.model;

import java.util.List;

public class SkiModel {
	private List<Integer> path;
	private int lengthPath;
	private int dropPath;
	public List<Integer> getPath() {
		return path;
	}
	public void setPath(List<Integer> path) {
		this.path = path;
	}
	public int getLengthPath() {
		return lengthPath;
	}
	public void setLengthPath(int lengthPath) {
		this.lengthPath = lengthPath;
	}
	public int getDropPath() {
		return dropPath;
	}
	public void setDropPath(int dropPath) {
		this.dropPath = dropPath;
	}
	@Override
	public String toString() {
		return "SkiModel [path=" + path + ", lengthPath=" + lengthPath + ", dropPath=" + dropPath + "]";
	}
}