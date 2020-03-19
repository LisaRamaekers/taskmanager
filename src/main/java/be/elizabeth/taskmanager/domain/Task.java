package be.elizabeth.taskmanager.domain;

//import be.elizabeth.taskmanager.converter.LocalDateTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long taskId;

    @NotEmpty
    private String title;

    private String description;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime due;

    private Boolean done;

   /* TODO: implement subtasks
   @OneToMany
    private List<Task> subTasks;*/

    /*public Task() {

    }
    public Task(String title, String description, LocalDateTime due) {
        setTitle(title);
        setDescription(description);
        setDue(due);
        setDone(false);
        setSubTasks(new ArrayList<>());
    }

    public Task(String description, String due) {
        setDescription(description);
        setDue(due);
        setDone(false);
    }*/

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
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

    @Override
    public String toString(){
        return getDescription() + ": " + getDue() + " (" + getDone() + ")";
    }


    /* TODO: implement subtasks
    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }*/
}
