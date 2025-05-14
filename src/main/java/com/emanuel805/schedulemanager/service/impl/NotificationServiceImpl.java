package com.emanuel805.schedulemanager.service.impl;

import com.emanuel805.schedulemanager.dto.TaskDTO;
import com.emanuel805.schedulemanager.model.Task;
import com.emanuel805.schedulemanager.service.NotificationService;
import com.emanuel805.schedulemanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final TaskService taskService;

    @Autowired
    public NotificationServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public void showTaskNotification() {
        List<TaskDTO> dueSoonTasks = taskService.getAllTasks();
        LocalDate today = LocalDate.now();
        dueSoonTasks.stream()
                .filter(taskDTO -> taskDTO.deadline().isBefore(today.plusDays(1)))
                .forEach(taskDTO -> System.out.println(taskDTO.name() + " is due soon on " + taskDTO.deadline()));

    }
}
