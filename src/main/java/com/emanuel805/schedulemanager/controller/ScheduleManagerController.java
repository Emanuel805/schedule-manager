package com.emanuel805.schedulemanager.controller;

import com.emanuel805.schedulemanager.dto.TaskDTO;
import com.emanuel805.schedulemanager.service.NotificationService;
import com.emanuel805.schedulemanager.service.TaskService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleManagerController {
    @FXML
    private ListView<String> taskListView;

    private final TaskService taskService;
    private final NotificationService notificationService;

    public ScheduleManagerController(NotificationService notificationService, TaskService taskService) {
        this.notificationService = notificationService;
        this.taskService = taskService;
    }

    @FXML
    public void checkForUpcomingTasks() {
        List<TaskDTO> upcomingTasks = taskService.getUpcomingTasks();
        taskListView.getItems().clear();
        upcomingTasks.forEach(task -> taskListView.getItems().add(task.name()));
        notificationService.showTaskNotification("Upcoming tasks updated!");
    }
}
