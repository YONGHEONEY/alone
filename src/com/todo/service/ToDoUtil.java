package com.todo.service;

import java.util.Scanner;

import com.todo.dao.ToDoItem;
import com.todo.dao.ToDoList;

public class ToDoUtil {
	public static void createItem(ToDoList list) {
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 추가]\n"
				+ "제목 ->");
		
		title = sc.next();
		if(list.isDuplicate(title)) {
			System.out.println("제목이 중복됩니다..");
			return;
		}
		sc.nextLine(); // Enter를 제거하기 위해 넣음
		System.out.println("내용-> ");
		desc = sc.nextLine().trim(); // trim() 좌우 여백을 제거하기위한 내용
		
		ToDoItem t = new ToDoItem(title, desc);
		list.addItem(t);
		System.out.println("추가되었습니다..");
	}
	
	public static void deleteItem(ToDoList l) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 삭제]\n"
				+ "삭제할 항목의 제목을 입력하세요..");
		String title = sc.next();
		
		for(ToDoItem item : l.getList()) {
			if(title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("삭제되었습니다..");
				break;
			}
		}
				
	}
	public static void updateItem(ToDoList l) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 수정]\n"
				+ "수정할 항목의 제목을 입력하세요..");
		String title = sc.next().trim();
		if(!l.isDuplicate(title)) {
			System.out.println("없는 제목입니다..");
			return;
		}
		
		System.out.print("새 제목 :");
		String new_title = sc.next().trim();
		if(l.isDuplicate(new_title)) {
			System.out.println("제목이 중복됩니다..");
			return;
		}
		sc.nextLine();
		System.out.print("새 내용 : ");
		String new_description = sc.nextLine().trim();
		for(ToDoItem item : l.getList()) {
			if(item.getTitle().equals(title)) {
				l.deleteItem(item);
				ToDoItem t = new ToDoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("수정되었습니다..");
			}
		}
	}
		public static void listAll(ToDoList l) {
			System.out.println("[전체 목록]");
			for(ToDoItem item : l.getList()) {
				System.out.println(item.toString());
			}
		}

}
