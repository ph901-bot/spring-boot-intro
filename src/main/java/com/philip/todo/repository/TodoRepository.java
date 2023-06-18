package com.philip.todo.repository;

import com.philip.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> { // this allows your repository to perform CRUD operations on Todo Entity
}
