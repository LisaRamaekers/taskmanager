package be.elizabeth.taskmanager.service;

import be.elizabeth.taskmanager.domain.Task;
import be.elizabeth.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }


    @Override
    public Task get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Task> getAll() {
        return repository.getTasks();
    }

    @Override
    public void add(Task task) {
        repository.add(task);
    }

    @Override
    public void update(Task task){
        repository.update(task);
    }

    @Override
    public void addSubTask(int id, Task task) {
        repository.get(id).getSubTasks().add(task);
    }

    @Override
    public List<Task> getSubTasks(int id) {
        return null;
    }
}
