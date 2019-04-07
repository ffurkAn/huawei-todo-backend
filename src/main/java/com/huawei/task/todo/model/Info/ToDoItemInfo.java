package com.huawei.task.todo.model.Info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItemInfo {

    private String name;
    private String description;
    private Date deadline;
    private String status;
    private String toDoListOid;
}
