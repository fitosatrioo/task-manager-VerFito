package com.task.manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "UserTask")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue
    private Long taskId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private java.time.LocalDateTime deadline;
    private java.time.LocalDateTime reminderTime;
}
