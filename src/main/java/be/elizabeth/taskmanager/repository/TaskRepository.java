package be.elizabeth.taskmanager.repository;


import be.elizabeth.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findFirstByTitle(String title);
}
