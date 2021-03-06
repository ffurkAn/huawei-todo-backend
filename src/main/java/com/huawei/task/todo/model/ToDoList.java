package com.huawei.task.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objId;
    private String name;
    private String userEmail;

    //@ManyToOne
    //private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "toDoListOid", referencedColumnName = "objId")
    private List<ToDoItem> items;

}
