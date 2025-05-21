package com.task.manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_task_id")

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    // @JsonIgnore
    // @OneToMany(mappedBy = "taskId")
    // private TaskList<Task> taskList;

}