package com.emanuel805.schedulemanager.service.impl;

import com.emanuel805.schedulemanager.dto.TaskDTO;
import com.emanuel805.schedulemanager.service.NotificationService;
import com.emanuel805.schedulemanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);
    private final TaskService taskService;

    @Autowired
    public NotificationServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public void showTaskNotification() {
        List<TaskDTO> dueSoonTasks = taskService.getAllTasks();
        LocalDate today = LocalDate.now();
        dueSoonTasks.sort(Comparator.comparing(TaskDTO::priority)); // sorts in ascending order
        //dueSoonTasks.sort(Comparator.comparing(TaskDTO::priority).reversed());
        dueSoonTasks.stream()
                .filter(taskDTO -> taskDTO.deadline().isBefore(today.plusDays(1)))
                .forEach(taskDTO ->
                        LOGGER.info("{} is due soon on {}", taskDTO.name(), taskDTO.deadline()));
    }
}
