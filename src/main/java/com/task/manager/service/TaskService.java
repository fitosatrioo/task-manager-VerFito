package com.task.manager.service;

import com.task.manager.model.Task;
import com.task.manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // This method should be called every hour to check for tasks with reminders
    @Scheduled(cron = "0 0/1 * * * ?") // every 1 minute for demo; change to 0 0/1 * * * ? for every hour
    public void sendReminders() {
        List<Task> tasks = taskRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for (Task task : tasks) {
            if (task.getReminderTime() != null &&
                    task.getReminderTime().isAfter(now) &&
                    task.getReminderTime().isBefore(now.plusHours(1))) {
                // TODO: Implement notification logic (email, push, etc.)
                System.out.println("Reminder: Task '" + task.getTitle() + "' is due soon!");
            }
        }
    }
}