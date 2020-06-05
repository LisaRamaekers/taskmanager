package be.elizabeth.taskmanager.DTO;

import be.elizabeth.taskmanager.domain.SubTask;
import be.elizabeth.taskmanager.domain.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTaskDtoTest {

    @Test
    public void test_create_subtaskDTO(){
        // ARRANGE

        // ACT
        SubTaskDTO st = new SubTaskDTO();
        st.setId(1L);
        st.setTitle("Title");
        st.setDescription("Description");

        // ASSERT
        assertEquals(1L,st.getId());
        assertEquals("Title",st.getTitle());
        assertEquals("Description",st.getDescription());

    }

    @Test
    public void test_add_subtaskDTO_to_taskDTO(){
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
        assertEquals(t,st.getTask());
    }

    @Test
    public void test_subtaskdto_hashcode(){
        // ARRANGE
        SubTaskDTO st;

        //ACT
        st = new SubTaskDTO();

        //ASSERT
        assertEquals(31, st.hashCode());
    }
}
