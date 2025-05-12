package com.emanuel805.schedulemanager.service.impl;

import com.emanuel805.schedulemanager.dto.TaskDTO;
import com.emanuel805.schedulemanager.model.Task;
import com.emanuel805.schedulemanager.repository.TaskRepository;
import com.emanuel805.schedulemanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO getTaskById(long id) {
        Task foundtask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id" + id + "not found"));
        return convertTaskToDTO(foundtask);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> alltasks = taskRepository.findAll();

        return alltasks.stream()
                .map(task -> convertTaskToDTO(task)).toList();
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = convertTaskDTOToTask(taskDTO);
        Task savedTask = taskRepository.save(task);
        return convertTaskToDTO(savedTask);
    }

    @Override
    public TaskDTO updateTask(long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskDTO.id())
                .orElseThrow(() -> new RuntimeException("Task with id" + id + "not found"));
        Task updatedTask = taskRepository.save(task);
        return convertTaskToDTO(updatedTask);
    }

    @Override
    public void deleteTask(long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task with id" + id + "not found");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDTO> getUpcomingTasks() {
        LocalDate upcomingDate = LocalDate.now().plusDays(10);
        return taskRepository.findByDeadlineBefore(upcomingDate)
                .stream()
                .map(this::convertTaskToDTO)
                .collect(Collectors.toList());
    }

    private TaskDTO convertTaskToDTO(Task task) {
        return new TaskDTO(task.getId(), task.getName(), task.getDescription(), task.getDeadline(), task.getPriority());
    }

    private Task convertTaskDTOToTask(TaskDTO taskDTO) {
        return new Task(taskDTO.name(), taskDTO.description(), taskDTO.deadline(), taskDTO.priority());
    }
}
