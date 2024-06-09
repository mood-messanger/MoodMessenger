package to.us.moodmessenger.MoodMessenger.services;

import to.us.moodmessenger.MoodMessenger.model.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> listUsers();
    UserDTO getuserById(UUID id);
    UserDTO getuserByUsername(String username);
    UserDTO saveNewUser(UserDTO beer);
    UserDTO updateUser(UUID id, UserDTO userDTO);
    UserDTO patchUser(UUID id, UserDTO userDTO);
}
