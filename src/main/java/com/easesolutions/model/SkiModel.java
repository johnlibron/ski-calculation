package com.easesolutions.model;

import java.util.List;

public class SkiModel {
	private List<String> axis;
	private List<Integer> path;
	private Integer lengthPath;
	private Integer dropPath;
	public List<String> getAxis() {
		return axis;
	}
	public void setAxis(List<String> axis) {
		this.axis = axis;
	}
	public List<Integer> getPath() {
		return path;
	}
	public void setPath(List<Integer> path) {
		this.path = path;
	}
	public Integer getLengthPath() {
		return lengthPath;
	}
	public void setLengthPath(Integer lengthPath) {
		this.lengthPath = lengthPath;
	}
	public Integer getDropPath() {
		return dropPath;
	}
	public void setDropPath(Integer dropPath) {
		this.dropPath = dropPath;
	}
	@Override
	public String toString() {
		return "SkiModel [axis=" + axis + ", path=" + path + ", lengthPath=" + lengthPath + ", dropPath=" + dropPath
				+ "]";
	}
}