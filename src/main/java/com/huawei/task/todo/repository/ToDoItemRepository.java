package com.huawei.task.todo.repository;

import com.huawei.task.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, String> {
}
