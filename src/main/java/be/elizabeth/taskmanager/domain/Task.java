package be.elizabeth.taskmanager.domain;

//import be.elizabeth.taskmanager.converter.LocalDateTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="Task")
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime due;

    private Boolean done;

    @OneToMany(
            mappedBy = "task",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SubTask> subTasks = new ArrayList<>();


    // GETTERS AND SETTERS
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

    public List<SubTask> getSubTasks() { return subTasks; }

    public void setSubTasks(List<SubTask> subTasks) { this.subTasks = subTasks; }

    @Override
    public String toString(){
        return getDescription() + ": " + getDue() + " (" + getDone() + ")";
    }


    // Bidirectional @OneToMany
    // Methods addSubtask ans removeSubtask

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
        subTask.setTask(this);
    }

    /*public void removeSubTask(SubTask subTask) {
        subTasks.remove(subTask);
        subTask.setTask(null);
    }*/
}
