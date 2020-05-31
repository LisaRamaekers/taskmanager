package be.elizabeth.taskmanager.repository;

import be.elizabeth.taskmanager.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
