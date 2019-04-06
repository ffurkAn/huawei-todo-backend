package com.huawei.task.todo.model.Info;

import com.huawei.task.todo.model.ToDoItem;
import com.huawei.task.todo.model.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListInfo {

    private String objId;
    private String name;
    private String userEmail;
    //private UserInfo user;
    private List<ToDoItem> items;

    public static ToDoListInfo map(ToDoList toDoList){
        return new ToDoListInfo(
                toDoList.getObjId().toString(),
                toDoList.getName(),
                toDoList.getUserEmail(),
                //UserInfo.map(toDoList.getUser()),
                toDoList.getItems()
        );
    }

    public static List<ToDoListInfo> mapAll(List<ToDoList> toDoLists){
        List<ToDoListInfo> toDoListInfos = new ArrayList<>();

        if(toDoLists != null){
            for(ToDoList toDoList : toDoLists){
                toDoListInfos.add(ToDoListInfo.map(toDoList));
            }
        }

        return toDoListInfos;
    }
}
