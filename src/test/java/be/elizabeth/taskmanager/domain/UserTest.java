package be.elizabeth.taskmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void test_create_user(){
        // ARRANGE

        // ACT
        User u = new User();
        u.setId(1L);
        u.setUsername("Name");
        u.setPassword("Pwd");
        u.setRole(UserRole.ADMIN);

        // ASSERT
        assertEquals(1L,u.getId());
        assertEquals("Name",u.getUsername());
        assertEquals("Pwd",u.getPassword());
        assertEquals(UserRole.ADMIN,u.getRole());

    }

}
