package com.todo.dao;

import java.util.*;

public class ToDoItem {
	private String title; // 할일
	private String desc; // 내용
	private Date current_date; // 입력시간 
	
	public ToDoItem(String title, String desc) {
		this.title = title;
		this.desc = desc;
		this.current_date = new Date(); // 현재 시간을 current_date 에 입력
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Date getCurrent_date() {
		return current_date;
	}
	
	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}

	@Override
	public String toString() {
		return "ToDoItem [제목=" + title + ", 내용=" + desc + ", 날짜=" + current_date + "]";
	}
	
	

}
