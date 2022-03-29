package com.todo.service;

import java.util.Comparator;

import com.todo.dao.ToDoItem;

public class ToDoSortByDate implements Comparator<ToDoItem>{
	@Override
	public int compare(ToDoItem o1, ToDoItem o2) {
		return o1.getCurrent_date().compareTo(o2.getCurrent_date());
	}

}
