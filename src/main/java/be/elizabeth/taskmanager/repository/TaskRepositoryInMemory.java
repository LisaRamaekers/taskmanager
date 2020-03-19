package be.elizabeth.taskmanager.repository;

import be.elizabeth.taskmanager.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryInMemory {
	/*
	private List<Task> list;
	private int id;

	public TaskRepository() {
		list = new ArrayList<>();
		this.add(new Task("TO DO 1","Description for task 1", LocalDateTime.now()));
		this.add(new Task("TO DO 2","Description for task 2", LocalDateTime.now()));
		this.add(new Task("TO DO 3","Description for task 3", LocalDateTime.now()));

	}

	public List<Task> getTasks() {
		return list;
	}


	public void add(Task task) {
		task.setTaskId(id);
		list.add(task);
		id++;
	}

	public Task get(int id){
		return list.get(id);
	}

	public void update(Task task){
		for( Task t : list){
			if (t.getTaskId() == task.getTaskId()){
				t.setTitle(task.getTitle());
				t.setDescription(task.getDescription());
				t.setDue(task.getDue());
			}
		}
	}

	 */
}
