package be.elizabeth.taskmanager.service;

import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.domain.Task;
import be.elizabeth.taskmanager.repository.TaskRepository;
import be.elizabeth.taskmanager.repository.TaskRepositoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }


    @Override
    public TaskDTO get(long id) {
        Task t = repository.getOne(id);
        return getTaskDTO(t);
    }

    private TaskDTO getTaskDTO(Task t) {
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(t.getTaskId());
        dto.setTitle(t.getTitle());
        dto.setDescription(t.getDescription());
        dto.setDue(t.getDue());
        dto.setDone(t.getDone());
        return dto;
    }

    @Override
    public List<TaskDTO> getAll() {
        return repository.findAll().stream().map(this::getTaskDTO).collect(Collectors.toList());
    }

    @Override
    public void add(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDue(taskDTO.getDue());
        task.setDone(false);
        repository.save(task);
    }

    @Override
    public void update(TaskDTO taskDTO){
        Task taskToUpdate = repository.getOne(taskDTO.getTaskId());
        taskToUpdate.setTitle(taskDTO.getTitle());
        taskToUpdate.setDescription(taskDTO.getDescription());
        taskToUpdate.setDue(taskDTO.getDue());
        taskToUpdate.setDone(taskDTO.getDone());
        repository.save(taskToUpdate);
    }

    /*
    @Override
    public void addSubTask(int id, Task task) {
        repository.get(id).getSubTasks().add(task);
    }

    @Override
    public List<Task> getSubTasks(int id) {
        return null;
    }*/
}
