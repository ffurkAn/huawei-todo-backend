package com.huawei.task.todo.web;

import com.huawei.task.todo.model.Form.LoginForm;
import com.huawei.task.todo.model.Info.UserInfo;
import com.huawei.task.todo.model.User;
import com.huawei.task.todo.service.UserService;
import com.huawei.task.todo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(value = Constants.LOGIN_CONTROLLER)
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = Constants.LOGIN_CONTROLLER_LOGIN, method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginForm loginForm)  {

        UserInfo user = userService.findByLoginCredentials(loginForm);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @RequestMapping(value = Constants.LOGIN_CONTROLLER_SIGN_UP, method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody LoginForm loginForm) {

        User savedUser = userService.save(loginForm);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

}
