package com.emanuel805.schedulemanager.repository;

import com.emanuel805.schedulemanager.dto.TaskDTO;
import com.emanuel805.schedulemanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByDeadlineBefore(LocalDate date);
    
}
