package com.huawei.task.todo.service.Impl;

import com.huawei.task.todo.exception.TODOException;
import com.huawei.task.todo.model.Form.LoginForm;
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
    public Optional<User> findByLoginCredentials(LoginForm loginForm){
        Optional<User> user = userRepository.findByEmail(loginForm.getEmail());

        if(!user.isPresent()){
            throw new TODOException(String.valueOf(HttpStatus.NOT_FOUND.value()), "kullanıcı bulunamadı");
        }

        if(!user.get().getPassword().equals(loginForm.getPassword())){
            throw new TODOException(String.valueOf(HttpStatus.NOT_FOUND.value()),"Kullanıcı adı ya da şifre hatalı");
        }

        return user;
    }

    @Override
    public User save(LoginForm loginForm) {

        Optional<User> user = userRepository.findByEmail(loginForm.getEmail());

        if(user.isPresent()) {
            throw new TODOException(String.valueOf(HttpStatus.NOT_FOUND.value()),"Bu email ile kayıtlı kullanıcı vardır");
        }

        User newUser = new User();
        newUser.setEmail(loginForm.getEmail());
        newUser.setPassword(loginForm.getPassword());

        return userRepository.save(newUser);

    }
}
