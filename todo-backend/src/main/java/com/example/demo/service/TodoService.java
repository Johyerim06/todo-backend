package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 모든 To-Do 리스트 조회
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 새로운 To-Do 추가
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 특정 To-Do 삭제
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // 특정 To-Do 완료 상태 변경 (토글 기능)
    public Todo toggleTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }
}
