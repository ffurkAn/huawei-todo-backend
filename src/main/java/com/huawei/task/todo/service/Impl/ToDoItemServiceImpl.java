package com.huawei.task.todo.service.Impl;

import com.huawei.task.todo.model.Info.ToDoItemInfo;
import com.huawei.task.todo.model.ToDoItem;
import com.huawei.task.todo.repository.ToDoItemRepository;
import com.huawei.task.todo.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "toDoItemService")
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public void saveItem(ToDoItemInfo toDoItemInfo) {

        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setName(toDoItemInfo.getName());
        toDoItem.setDeadline(toDoItemInfo.getDeadline());
        toDoItem.setDescription(toDoItemInfo.getDescription());
        toDoItem.setStatus("UNDONE");


        toDoItemRepository.save(toDoItem);

    }
}
