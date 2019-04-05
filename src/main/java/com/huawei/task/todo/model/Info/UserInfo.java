package com.huawei.task.todo.model.Info;

import com.huawei.task.todo.model.ToDoList;
import com.huawei.task.todo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String email;
    private String password;
    private List<ToDoListInfo> lists;

    public static UserInfo map(User user){
        return new UserInfo(
                user.getEmail(),
                user.getPassword(),
                ToDoListInfo.mapAll(user.getToDoLists())
        );
    }
}
