package be.elizabeth.taskmanager.service;

import be.elizabeth.taskmanager.DTO.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Qualifier("UserServiceImpl")
    @Autowired
    UserService users;

    @Test
    public void test_service_load_existing_user(){
        // ARRANGE

        // ACT
        UserDetails ud = users.loadUserByUsername("the_admin");

        // ASSERT
        assertEquals("the_admin",ud.getUsername());

    }

    @Test
    public void test_service_load_non_existing_user(){
        // ARRANGE

        // ACT / ASSERT
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            users.loadUserByUsername("the_test_user_that_does_not_exist");
        });

        String expectedMessage = "User does not exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}
