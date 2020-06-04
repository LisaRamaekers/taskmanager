package be.elizabeth.taskmanager.service;


import be.elizabeth.taskmanager.DTO.SubTaskDTO;
import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {
    TaskDTO get(Long id);
    List<TaskDTO> getAll();
    void add(TaskDTO task);
    void update(TaskDTO task);
    void delete(Long id);

    TaskDTO getByTitle(String title);

    void addToTask(Long id, SubTaskDTO subtask);
    List<SubTaskDTO> getAllFromTask(Long id);
}
