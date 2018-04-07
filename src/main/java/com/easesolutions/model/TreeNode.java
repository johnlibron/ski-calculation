package com.easesolutions.model;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;
	public TreeNode(T data) {
		this.data = data;
		this.parent = null;
		this.children = new LinkedList<TreeNode<T>>();
	}
	public TreeNode<T> addChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
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
	public List<TreeNode<T>> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	public boolean isRoot() {
		return parent == null;
	}
	public boolean isLeaf() {
		return children.size() == 0;
	}
	public int getLevel() {
		if (this.isRoot()) {
			return 0;
		} else {
			return parent.getLevel() + 1;
		}	
	}
}