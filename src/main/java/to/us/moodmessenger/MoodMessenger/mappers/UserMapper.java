package to.us.moodmessenger.MoodMessenger.mappers;

import org.mapstruct.Mapper;
import to.us.moodmessenger.MoodMessenger.entities.User;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;

@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);

}
