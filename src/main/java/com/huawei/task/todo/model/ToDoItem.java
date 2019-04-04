package com.huawei.task.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objId;
    private String name;
    private String description;
    private Date deadline;
    private String status;

    @OneToOne
    private ToDoList toDoList;


}
