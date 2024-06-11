package to.us.moodmessenger.MoodMessenger.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import to.us.moodmessenger.MoodMessenger.mappers.UserMapper;
import to.us.moodmessenger.MoodMessenger.repositories.UserRepository;
import to.us.moodmessenger.MoodMessenger.entities.User;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;
import to.us.moodmessenger.MoodMessenger.utils.PasswordUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceJPAImp implements UserService{
    public final UserRepository userRepository;
    public final UserMapper userMapper;
    @Override
    public List<UserDTO> listUsers() {
        List<User> userList;
        userList = userRepository.findAll();

        return  userList.stream().map(userMapper::userToUserDTO).toList();
    }

    @Override
    public UserDTO getuserById(UUID id) {
        return userMapper.userToUserDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserDTO getuserByUsername(String username) {

        return null;
    }

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        userDTO.setPassword_hash(PasswordUtils.encryptPassword(userDTO.getPassword_hash()));
        userDTO.setCreated_date(LocalDateTime.now());
        userDTO.setUpdated_date(LocalDateTime.now());
        return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {

        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setBio(userDTO.getBio());
            user.setLocation(userDTO.getLocation());
            user.setCreated_date(userDTO.getCreated_date());
            user.setUpdated_date(LocalDateTime.now());
            user.setStatus(userDTO.getStatus());
            user.setPhone_number(userDTO.getPhone_number());
            user.setLastlogin_date(userDTO.getLastlogin_date());
            user.setPassword_hash(PasswordUtils.encryptPassword(userDTO.getPassword_hash()));

            return userMapper.userToUserDTO(userRepository.save(user));
        }
        return null;
    }

    @Override
    public UserDTO patchUser(UUID id, UserDTO userDTO) {
        return null;
    }
}
