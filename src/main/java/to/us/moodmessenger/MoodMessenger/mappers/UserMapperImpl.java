package to.us.moodmessenger.MoodMessenger.mappers;

import org.springframework.stereotype.Component;
import to.us.moodmessenger.MoodMessenger.entity.User;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User.UserBuilder user = User.builder();
        user.id(userDTO.getId());
        user.bio(userDTO.getBio());
        user.email(userDTO.getEmail());
        user.username(userDTO.getUsername());
        user.password_hash(userDTO.getPassword_hash());
        user.created_date(userDTO.getCreated_date());
        user.updated_date(userDTO.getUpdated_date());
        user.location(userDTO.getLocation());
        user.lastlogin_date(userDTO.getLastlogin_date());
        user.phone_number(userDTO.getPhone_number());
        user.status(userDTO.getStatus());
        return user.build();
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();
        userDTO.id(user.getId());
        userDTO.bio(user.getBio());
        userDTO.email(user.getEmail());
        userDTO.username(user.getUsername());
        userDTO.password_hash(user.getPassword_hash());
        userDTO.created_date(user.getCreated_date());
        userDTO.updated_date(user.getUpdated_date());
        userDTO.location(user.getLocation());
        userDTO.lastlogin_date(user.getLastlogin_date());
        userDTO.phone_number(user.getPhone_number());
        userDTO.status(user.getStatus());
        return userDTO.build();
    }
}
