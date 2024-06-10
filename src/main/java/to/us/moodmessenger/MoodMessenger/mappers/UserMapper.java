package to.us.moodmessenger.MoodMessenger.mappers;

import to.us.moodmessenger.MoodMessenger.entity.User;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;

public interface UserMapper {
    User userDTOToUser(UserDTO userDTO);
    UserDTO userToUserDTO(User user);
}
