package be.elizabeth.taskmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubTaskDomainTest {

    @Test
    public void test_create_subtask(){
        // ARRANGE

        // ACT
        SubTask st = new SubTask();
        st.setId(1L);
        st.setTitle("Title");
        st.setDescription("Description");

        // ASSERT
        assertEquals(1L,st.getId());
        assertEquals("Title",st.getTitle());
        assertEquals("Description",st.getDescription());

    }

    @Test
    public void test_add_subtask_to_task(){
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
        assertEquals(t,st.getTask());
    }

    @Test
    public void test_subtask_hashcode(){
        // ARRANGE
        SubTask st;

        //ACT
        st = new SubTask();

        //ASSERT
        assertEquals(31, st.hashCode());
    }
}
