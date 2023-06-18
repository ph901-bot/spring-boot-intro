package com.philip.todo.service;

import com.philip.todo.entity.Todo;
import com.philip.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    //Dependency Injection via Controller
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

//    @Autowired //Dependency Injection via Setter Method
//    public void setTodoRepository(TodoRepository todoRepository) {
//        this.todoRepository = todoRepository;
//    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo update(Todo todo){
        if (todo.getId() == null || todoRepository.findById(todo.getId()).isEmpty())
            throw new IllegalArgumentException("Update operation failed");

        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
