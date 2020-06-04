package be.elizabeth.taskmanager.service;
import be.elizabeth.taskmanager.DTO.CreateUserDTO;
import be.elizabeth.taskmanager.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDTO createUser(CreateUserDTO userDTO);
}
