package com.emanuel805.schedulemanager.service;

import com.emanuel805.schedulemanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks;
    TaskDTO createTask(TaskDTO taskDTO);
    void deleteTask(Long id);
}
