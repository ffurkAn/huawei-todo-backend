package com.huawei.task.todo.service;

import com.huawei.task.todo.model.Info.ToDoItemInfo;
import com.huawei.task.todo.model.Info.ToDoListInfo;
import com.huawei.task.todo.model.ToDoList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ToDoListService {

    List<ToDoListInfo> findAllByEmail(String email);

    void save(ToDoListInfo toDoListInfo);

}
