package be.elizabeth.taskmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name="SubTask")
@Table(name="sub_task")
public class SubTask {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTask )) return false;
        return id != null && id.equals(((SubTask) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
