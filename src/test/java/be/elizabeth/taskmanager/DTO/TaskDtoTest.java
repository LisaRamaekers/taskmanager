package be.elizabeth.taskmanager.DTO;

import be.elizabeth.taskmanager.domain.SubTask;
import be.elizabeth.taskmanager.domain.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskDtoTest {
    @Test
    public void test_create_taskDTO(){
        // ARRANGE

        // ACT
        TaskDTO t = new TaskDTO();
        t.setId(1L);
        t.setTitle("Title");
        t.setDescription("Description");
        t.setDue(LocalDateTime.now());
        t.setDone(true);

        // ASSERT
        assertEquals(1L,t.getId());
        assertEquals("Title",t.getTitle());
        assertEquals("Description",t.getDescription());
        assertEquals(true,t.getDone());

    }

    @Test
    public void test_add_subtaskDTO(){
        // ARRANGE
        TaskDTO t = new TaskDTO();
        t.setId(1L);
        t.setTitle("Title");
        t.setDescription("Description");
        SubTaskDTO st = new SubTaskDTO();
        st.setId(1L);
        st.setTitle("SubTask");
        st.setDescription("ST Description");

        // ACT
        t.addSubTask(st);

        // ASSERT
        assertEquals(st,t.getSubTasks().get(0));
        assertTrue(st.equals(t.getSubTasks().get(0)));
    }
}
