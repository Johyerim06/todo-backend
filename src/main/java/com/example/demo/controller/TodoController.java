package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")  // ✅ 모든 프론트엔드 요청 허용 (React와 통신 가능)

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 모든 To-Do 리스트 조회
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // 새로운 To-Do 추가
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    // 특정 To-Do 삭제
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    // 특정 To-Do 완료 상태 변경
    @PutMapping("/{id}")
    public Todo toggleTodo(@PathVariable Long id) {
        return todoService.toggleTodo(id);
    }
}
