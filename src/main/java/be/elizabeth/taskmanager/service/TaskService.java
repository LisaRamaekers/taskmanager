package be.elizabeth.taskmanager.service;


import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {
    TaskDTO get(long id);
    List<TaskDTO> getAll();
    void add(TaskDTO task);
    void update(TaskDTO task);
    //void addSubTask(int id, TaskDTO task);
    //List<TaskDTO> getSubTasks(int id);
}
