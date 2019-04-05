package com.huawei.task.todo.repository;

import com.huawei.task.todo.model.ToDoList;
import com.huawei.task.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, String> {

    List<ToDoList> findAllByUserEmail(String email);
}
