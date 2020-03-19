package be.elizabeth.taskmanager.service;


import be.elizabeth.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {
    Task get(int id);
    List<Task> getAll();
    void add(Task task);
    void update(Task task);
    void addSubTask(int id, Task task);
    List<Task> getSubTasks(int id);
}
