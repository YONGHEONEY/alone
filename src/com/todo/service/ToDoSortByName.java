package com.todo.service;

import java.util.Comparator;

import com.todo.dao.ToDoItem;

public class ToDoSortByName implements Comparator<ToDoItem>{
	@Override
	public int compare(ToDoItem o1, ToDoItem o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
