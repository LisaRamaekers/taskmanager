package be.elizabeth.taskmanager.rest.controller;

import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaskDTO> getTasks() {
        return taskService.getAll();
    }

    @PostMapping("/task")
    public void createNewTask(@RequestBody @Valid TaskDTO taskDTO){
        taskService.add(taskDTO);
    }
}
