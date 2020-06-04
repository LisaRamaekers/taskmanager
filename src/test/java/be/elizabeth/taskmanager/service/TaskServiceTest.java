package be.elizabeth.taskmanager.service;

import be.elizabeth.taskmanager.DTO.SubTaskDTO;
import be.elizabeth.taskmanager.DTO.TaskDTO;
import be.elizabeth.taskmanager.domain.SubTask;
import be.elizabeth.taskmanager.domain.Task;
import be.elizabeth.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {
    @Qualifier("TaskServiceImpl")
    @Autowired
    TaskService tasks;

    @Test
    public void test_service_add_task(){
        // ARRANGE
        String taskTitle = generateRandomString();
        String taskDescription = generateRandomString();
        LocalDateTime taskDue = LocalDateTime.now();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(taskTitle);
        taskDTO.setDescription(taskDescription);
        taskDTO.setDue(taskDue);

        // ACT
        tasks.add(taskDTO);

        // ASSERT
        assertNotNull(tasks.getAll());
        TaskDTO retrievedTask = tasks.getByTitle(taskTitle);
        assertNotNull(retrievedTask);
        assertEquals(taskTitle, retrievedTask.getTitle());
        assertEquals(taskDescription, retrievedTask.getDescription());
        assertEquals(taskDue.getDayOfWeek(), retrievedTask.getDue().getDayOfWeek());
        assertEquals(taskDue.getMonth(), retrievedTask.getDue().getMonth());
        assertEquals(taskDue.getYear(), retrievedTask.getDue().getYear());

        // AFTER
        tasks.delete(retrievedTask.getId());

    }

    @Test
    public void test_service_add_task_and_subtask() {
        // ARRANGE
        String taskTitle = generateRandomString();
        String taskDescription = generateRandomString();
        LocalDateTime taskDue = LocalDateTime.now();
        String subtaskTitle = generateRandomString();
        String subtaskDescription = generateRandomString();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(taskTitle);
        taskDTO.setDescription(taskDescription);
        taskDTO.setDue(taskDue);
        SubTaskDTO subtask = new SubTaskDTO();
        subtask.setTitle(subtaskTitle);
        subtask.setDescription(subtaskDescription);

        // ACT
        tasks.add(taskDTO);
        TaskDTO retrievedTask = tasks.getByTitle(taskTitle);
        tasks.addToTask(retrievedTask.getId(), subtask); // Add subtask to task
        List<SubTaskDTO> retrievedSubtasks = tasks.getAllFromTask(retrievedTask.getId());

        // ASSERT
        assertNotNull(tasks.getAll());
        assertNotNull(tasks.getAllFromTask(retrievedTask.getId()));
        SubTaskDTO retrievedSubtask = retrievedSubtasks.get(0);
        assertEquals(taskTitle, retrievedTask.getTitle());
        assertEquals(subtaskTitle, retrievedSubtask.getTitle());
        assertEquals(subtaskDescription, retrievedSubtask.getDescription());

        // AFTER
        tasks.delete(retrievedTask.getId());

    }

    @Test
    public void test_service_update_task(){
        // ARRANGE
        String taskTitle = generateRandomString();
        String newTaskTitle = generateRandomString();
        String taskDescription = generateRandomString();
        String newTaskDescription = generateRandomString();
        LocalDateTime taskDue = LocalDateTime.now();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(taskTitle);
        taskDTO.setDescription(taskDescription);
        taskDTO.setDue(taskDue);

        tasks.add(taskDTO);

        // ACT
        TaskDTO retrievedTask = tasks.getByTitle(taskTitle);
        Long taskId = retrievedTask.getId();
        retrievedTask.setTitle(newTaskTitle);
        retrievedTask.setDescription(newTaskDescription);
        tasks.update(retrievedTask);

        // ASSERT
        TaskDTO newRetrievedTask = tasks.get(taskId);
        assertNotNull(newRetrievedTask);
        assertEquals(newTaskTitle, newRetrievedTask.getTitle());
        assertEquals(newTaskDescription, newRetrievedTask.getDescription());

        // AFTER
        tasks.delete(taskId);
    }

    @Test
    public void test_service_remove_task(){
        // ARRANGE
        String taskTitle = generateRandomString();
        String taskDescription = generateRandomString();
        LocalDateTime taskDue = LocalDateTime.now();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(taskTitle);
        taskDTO.setDescription(taskDescription);
        taskDTO.setDue(taskDue);

        tasks.add(taskDTO);

        // ACT
        Integer amountOfTasksBefore = tasks.getAll().size();
        TaskDTO retrievedTask = tasks.getByTitle(taskTitle);
        Long taskId = retrievedTask.getId();
        tasks.delete(taskId);
        Integer amountOfTasksAfter = tasks.getAll().size();

        // ASSERT
        if (amountOfTasksBefore == 1) assertNull(amountOfTasksAfter);
        else assertEquals(1, amountOfTasksBefore - amountOfTasksAfter);

        assertNull(tasks.get(taskId));
        assertNull(tasks.getByTitle(taskTitle));

        // AFTER
        tasks.delete(taskId);
    }

    private String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 20;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        buffer.append("TEST");
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
