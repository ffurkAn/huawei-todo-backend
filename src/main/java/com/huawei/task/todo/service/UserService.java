package com.huawei.task.todo.service;

import com.huawei.task.todo.exception.TODOException;
import com.huawei.task.todo.model.Form.LoginForm;
import com.huawei.task.todo.model.Info.UserInfo;
import com.huawei.task.todo.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {

    UserInfo findByLoginCredentials(LoginForm loginForm) throws TODOException;

    User save(LoginForm newUser) throws TODOException;
}
