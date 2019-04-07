package com.huawei.task.todo.web;

import com.huawei.task.todo.model.Form.LoginForm;
import com.huawei.task.todo.model.Info.ToDoItemInfo;
import com.huawei.task.todo.model.Info.ToDoListInfo;
import com.huawei.task.todo.model.ToDoItem;
import com.huawei.task.todo.model.ToDoList;
import com.huawei.task.todo.model.User;
import com.huawei.task.todo.service.ToDoItemService;
import com.huawei.task.todo.service.ToDoListService;
import com.huawei.task.todo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = Constants.TO_DO_LIST_CONTROLLER)
public class ToDoListController {

    @Autowired
    ToDoListService toDoListService;

    @Autowired
    ToDoItemService toDoItemService;

    @RequestMapping(value = Constants.TO_DO_LIST_CONTROLLER_GET_ALL, method = RequestMethod.POST)
    public ResponseEntity<List<ToDoListInfo>> getAllToDoList(@RequestBody LoginForm loginForm)  {

        List<ToDoListInfo> toDoListInfo = toDoListService.findAllByEmail(loginForm.getEmail());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(toDoListInfo);
    }

    @RequestMapping(value = Constants.TO_DO_LIST_CONTROLLER_SAVE_NEW_LIST, method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody ToDoListInfo toDoListInfo){

        toDoListService.save(toDoListInfo);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(true);
    }

    @RequestMapping(value = Constants.TO_DO_LIST_CONTROLLER_SAVE_NEW_ITEM, method = RequestMethod.POST)
    public ResponseEntity saveItem(@RequestBody ToDoItemInfo toDoItemInfo){

        toDoItemService.saveItem(toDoItemInfo);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(true);
    }
}
