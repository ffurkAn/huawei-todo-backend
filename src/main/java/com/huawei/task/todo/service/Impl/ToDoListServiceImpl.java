package com.huawei.task.todo.service.Impl;

import com.huawei.task.todo.model.Info.ToDoItemInfo;
import com.huawei.task.todo.model.Info.ToDoListInfo;
import com.huawei.task.todo.model.ToDoList;
import com.huawei.task.todo.repository.ToDoListRepository;
import com.huawei.task.todo.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "toDoListService")
public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Override
    public List<ToDoListInfo> findAllByEmail(String email) {
        return ToDoListInfo.mapAll(toDoListRepository.findAllByUserEmail(email));
    }

    @Override
    public void save(ToDoListInfo toDoListInfo) {

        ToDoList toDoList = new ToDoList();
        toDoList.setName(toDoListInfo.getName());
        toDoList.setUserEmail(toDoListInfo.getUserEmail());


        toDoListRepository.save(toDoList);
    }


}
