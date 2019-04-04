package com.huawei.task.todo.model.Info;

import com.huawei.task.todo.model.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long objId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<ToDoList> lists;
}
