package com.huawei.task.todo.service;

import com.huawei.task.todo.model.Info.ToDoItemInfo;
import org.springframework.stereotype.Component;

@Component
public interface ToDoItemService {

    void saveItem(ToDoItemInfo toDoItemInfo);

}
