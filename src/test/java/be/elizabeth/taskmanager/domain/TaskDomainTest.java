package be.elizabeth.taskmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskDomainTest {

    @Test
    public void test_create_task(){
        // ARRANGE

        // ACT
        Task t = new Task();
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
    public void test_add_subtask(){
        // ARRANGE
        Task t = new Task();
        t.setId(1L);
        t.setTitle("Title");
        t.setDescription("Description");
        SubTask st = new SubTask();
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
