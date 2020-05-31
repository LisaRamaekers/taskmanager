package be.elizabeth.taskmanager.service;

import be.elizabeth.taskmanager.DTO.SubTaskDTO;
import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.domain.SubTask;
import be.elizabeth.taskmanager.domain.Task;
import be.elizabeth.taskmanager.repository.SubTaskRepository;
import be.elizabeth.taskmanager.repository.TaskRepository;
import be.elizabeth.taskmanager.repository.TaskRepositoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    private final SubTaskRepository subRepo;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, SubTaskRepository subRepo) {

        this.repository = repository;
        this.subRepo = subRepo;
    }


    @Override
    public TaskDTO get(Long id) {
        Task t = repository.getOne(id);
        return getTaskDTO(t);
    }

    private TaskDTO getTaskDTO(Task t) {
        TaskDTO dto = new TaskDTO();
        dto.setId(t.getId());
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
        Task taskToUpdate = repository.getOne(taskDTO.getId());
        taskToUpdate.setTitle(taskDTO.getTitle());
        taskToUpdate.setDescription(taskDTO.getDescription());
        taskToUpdate.setDue(taskDTO.getDue());
        taskToUpdate.setDone(taskDTO.getDone());
        repository.save(taskToUpdate);
    }

    @Override
    public void addToTask(Long id, SubTaskDTO subTaskDTO) {
        Task theTask = repository.getOne(id);

        SubTask subTask = new SubTask();
        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setDescription(subTaskDTO.getDescription());

        subTask.setTask(theTask);

        subRepo.save(subTask);
        repository.getOne(id).getSubTasks().add(subTask);
    }

    @Override
    public List<SubTaskDTO> getAllFromTask(Long id) {
        List<SubTask> subtasks = repository.getOne(id).getSubTasks();
        List<SubTaskDTO> subtaskDTOs = new ArrayList<>();
        for (SubTask s : subtasks){
            SubTaskDTO sub = new SubTaskDTO();
            sub.setTitle(s.getTitle());
            sub.setDescription(s.getDescription());
            subtaskDTOs.add(sub);
        }
        return subtaskDTOs;
    }


}
