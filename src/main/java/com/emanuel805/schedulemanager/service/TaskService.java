package com.emanuel805.schedulemanager.service;

import com.emanuel805.schedulemanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO getTaskById(long id);
    List<TaskDTO> getAllTasks();
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(long id, TaskDTO taskDTO);
    void deleteTask(long id);
}
