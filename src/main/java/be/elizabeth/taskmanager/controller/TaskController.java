package be.elizabeth.taskmanager.controller;

import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.domain.Task;
import be.elizabeth.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {this.taskService = taskService; }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getAll());
        return "tasks";
    }
    @GetMapping("/{id}")
    public String getTaskDetails(@PathVariable String id, Model model){
        try{
            model.addAttribute("task", taskService.get(Integer.parseInt(id)));
            return "detail";
        }catch(Exception e){
            return "notFound";
        }
    }
    @GetMapping("/new")
    public String getCreateForm(){
            return "form";
    }
    @PostMapping("/new")
    public String postNewTask(@ModelAttribute TaskDTO task){
        taskService.add(task);
        return "redirect:/tasks";
    }
    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable String id, Model model){
        try{
            model.addAttribute("task", taskService.get(Integer.parseInt(id)));
            return "editForm";
        }catch(Exception e){
            return "notFound";
        }
    }
    @PostMapping("/edit/{id}")
    public String postEditTask(@ModelAttribute TaskDTO task, @PathVariable String id){
        task.setTaskId(Integer.parseInt(id));
        taskService.update(task);
        return "redirect:/tasks/{id}";
    }

    /*
    @GetMapping("/{id}/sub/create")
    public String getCreateSubForm(@PathVariable String id, Model model){
        model.addAttribute("task", taskService.get(Integer.parseInt(id)));
        return "subForm";
    }
    @PostMapping("/{id}/sub/create")
    public String postNewSubTask(@ModelAttribute TaskDTO task, @PathVariable String id){
        taskService.addSubTask(Integer.parseInt(id),task);
        return "redirect:/tasks";
    }

     */
}
