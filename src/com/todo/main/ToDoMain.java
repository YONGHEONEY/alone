package com.todo.main;

import java.util.Scanner;
import com.todo.dao.ToDoList;
import com.todo.menu.Menu;
import com.todo.service.ToDoUtil;

public class ToDoMain {
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		ToDoList l = new ToDoList();
		boolean isList = false;
		boolean quit = false;
		
		Menu.displaymenu();
		do { 
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch(choice){
			
			case "add":
				ToDoUtil.createItem(l);
				break;
				
			case "del":
				ToDoUtil.deleteItem(l);
				break;
				
			case "edit":
				ToDoUtil.updateItem(l);
				break;
				
			case "ls":
				ToDoUtil.listAll(l);
				break;
				
			case "ls_name_asc":
				l.sortByName();
				System.out.println("제목순으로 정렬하였습니다.");
				isList = true;
				break;
				
			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				System.out.println("제목역순으로 정렬하였습니다.");
				isList = true;
				break;
				
			case "ls_date":
				l.sortByDate();
				System.out.println("날짜순으로 정렬하였습니다.");
				isList = true;
				break;
				
			case "help":
				Menu.displaymenu();
				break;
				
			case "exit":
				quit = true;
				break;
				
			default:
				System.out.println("정확한 명령어를 입력하세요. (도움말 - help)");
				break;
					
			}
			if(isList) ToDoUtil.listAll(l);
		} while(!quit);
	}

}
