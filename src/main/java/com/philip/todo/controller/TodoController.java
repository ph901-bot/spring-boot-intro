package com.philip.todo.controller;

import com.philip.todo.entity.Todo;
import com.philip.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String todo(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todoList", todoService.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("todo") Todo todo) {
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable("id") Long id, Model model) {
        Todo todo = todoService.findById(id).get();
        model.addAttribute("todo", todo);
        model.addAttribute("todoList", todoService.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteById(id);
        return "redirect:/";
    }


}
