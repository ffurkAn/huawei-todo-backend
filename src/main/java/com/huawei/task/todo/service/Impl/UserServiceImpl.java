package com.huawei.task.todo.service.Impl;

import com.huawei.task.todo.exception.TODOException;
import com.huawei.task.todo.model.Form.LoginForm;
import com.huawei.task.todo.model.Info.UserInfo;
import com.huawei.task.todo.model.User;
import com.huawei.task.todo.repository.UserRepository;
import com.huawei.task.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserInfo findByLoginCredentials(LoginForm loginForm){
        User user = userRepository.findByEmail(loginForm.getEmail());

        if(user == null){
            throw new TODOException(String.valueOf(HttpStatus.NOT_FOUND.value()), "kullanıcı bulunamadı");
        }

        if(!user.getPassword().equals(loginForm.getPassword())){
            throw new TODOException(String.valueOf(HttpStatus.NOT_FOUND.value()),"Kullanıcı adı ya da şifre hatalı");
        }

        return UserInfo.map(user);
    }

    @Override
    public User save(LoginForm loginForm) {

        User user = userRepository.findByEmail(loginForm.getEmail());

        if(user != null){
            throw new TODOException(String.valueOf(HttpStatus.NOT_FOUND.value()),"Bu email ile kayıtlı kullanıcı vardır");
        }

        User newUser = new User();
        newUser.setEmail(loginForm.getEmail());
        newUser.setPassword(loginForm.getPassword());

        return userRepository.save(newUser);

    }
}
