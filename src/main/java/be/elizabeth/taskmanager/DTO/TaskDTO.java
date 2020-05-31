package be.elizabeth.taskmanager.DTO;

import be.elizabeth.taskmanager.domain.SubTask;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {

    private Long id;

    @NotEmpty
    private String title;

    private String description;

    private LocalDateTime due;

    private Boolean done;

    @OneToMany(
            mappedBy = "task",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SubTaskDTO> subTasks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubTaskDTO> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public String toString(){
        return getDescription() + ": " + getDue() + " (" + getDone() + ")";
    }

    public void addSubTask(SubTaskDTO subTask) {
        subTasks.add(subTask);
        subTask.setTask(this);
    }

    public void removeComment(SubTaskDTO subTask) {
        subTasks.remove(subTask);
        subTask.setTask(null);
    }

}

