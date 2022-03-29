package com.todo.dao;

import java.util.ArrayList;
import java.util.Collections;

import com.todo.service.ToDoSortByDate;
import com.todo.service.ToDoSortByName;

public class ToDoList {
	private ArrayList<ToDoItem> list; // 리스트 
	
	public ToDoList() {
		this.list = new ArrayList<ToDoItem>();
		// ToDoItem 리스트들을 하나씩하나씩 ArrayList 담는다
	}
	
	public void addItem(ToDoItem t) {
		list.add(t);
	}
	
	public void deleteItem(ToDoItem t) {
		list.remove(t);
	}
	
	void editItem(ToDoItem t, ToDoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
		
	}
	
	public ArrayList<ToDoItem> getList() {
		return new ArrayList<ToDoItem>(list);
	}
	
	public void sortByName() {
		Collections.sort(list, new ToDoSortByName());
	}
	
	public void reverseList() {
		Collections.reverse(list);
	}
	
	public void sortByDate() {
		Collections.sort(list, new ToDoSortByDate());
	}
	
	public int indexOf(ToDoItem t) {
		return list.indexOf(t);
	}
	
	public Boolean isDuplicate(String title) {
		for(ToDoItem item : list) {
		if(title.equals(item.getTitle())) return true;
	}
		return false;
	}
}