package be.elizabeth.taskmanager.DTO;

import be.elizabeth.taskmanager.domain.User;
import be.elizabeth.taskmanager.domain.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoTest {

    @Test
    public void test_create_userDTO(){
        // ARRANGE

        // ACT
        UserDTO u = new UserDTO();
        u.setId(1L);
        u.setUsername("Name");
        u.setRole(UserRole.ADMIN);

        // ASSERT
        assertEquals(1L,u.getId());
        assertEquals("Name",u.getUsername());
        assertEquals(UserRole.ADMIN,u.getRole());

    }
}
