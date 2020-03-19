package be.elizabeth.taskmanager.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

public class TaskDTO {

    private long taskId;

    @NotEmpty
    private String title;

    private String description;

    private LocalDateTime due;

    private Boolean done;

    /* TODO: implement subtasks
    @OneToMany
    private List<TaskDTO> subTasks;
     */

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
    public List<TaskDTO> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<TaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

 */
}

