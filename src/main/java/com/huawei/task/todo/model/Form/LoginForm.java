package com.huawei.task.todo.model.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    private String email;
    private String password;
    private boolean isNewUser;
}
