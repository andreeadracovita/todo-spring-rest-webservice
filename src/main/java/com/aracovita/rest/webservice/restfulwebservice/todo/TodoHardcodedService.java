package com.aracovita.rest.webservice.restfulwebservice.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "aracovita", "Learn Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "aracovita", "Run a marathon", new Date(), false));
		todos.add(new Todo(++idCounter, "aracovita", "Master Java", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null) {
			return null;
		}
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for (Todo todo: todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	
}
