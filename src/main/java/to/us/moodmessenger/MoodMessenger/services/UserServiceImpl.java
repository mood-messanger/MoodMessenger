package to.us.moodmessenger.MoodMessenger.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;
import to.us.moodmessenger.MoodMessenger.utils.PasswordUtils;

import java.util.*;
//@Primary
@Service
public class UserServiceImpl implements UserService {

    Map<UUID, UserDTO> userMap = new HashMap<>();

    public UserServiceImpl() {
        UserDTO userDTO1 = UserDTO.builder()
                .id(UUID.randomUUID())
                .username("username1")
                .password_hash(PasswordUtils.encryptPassword("password1"))
                .build();
        UserDTO userDTO2 = UserDTO.builder()
                .id(UUID.randomUUID())
                .username("username2")
                .password_hash(PasswordUtils.encryptPassword("password2"))
                .build();
        UserDTO userDTO3 = UserDTO.builder()
                .id(UUID.randomUUID())
                .username("username3")
                .password_hash(PasswordUtils.encryptPassword("password3"))
                .build();
        userMap.put(userDTO1.getId(), userDTO1);
        userMap.put(userDTO2.getId(), userDTO2);
        userMap.put(userDTO3.getId(), userDTO3);
    }

    @Override
    public List<UserDTO> listUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public UserDTO getuserById(UUID id) {
        return userMap.get(id);
    }

    @Override
    public UserDTO getuserByUsername(String username) {
        //Inefficentway for map if  id is used as key rather than username
        Set<Map.Entry<UUID, UserDTO>> entries = userMap.entrySet();
        for (Map.Entry<UUID, UserDTO> entry : entries) {
            if(entry.getValue().getUsername().equals(username)) {
                return entry.getValue();
            }
        }
        return null;

    }

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        userDTO.setId(UUID.randomUUID());
        userDTO.setPassword_hash(PasswordUtils.encryptPassword(userDTO.getPassword_hash()));
        return userMap.put(userDTO.getId(), userDTO);

    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
       userDTO.setId(id);
       return userMap.put(id, userDTO);
    }

    @Override
    public UserDTO patchUser(UUID id, UserDTO userDTOFromCall) {
        UserDTO userDTO1 = userMap.get(id);
        if(userDTOFromCall.getUsername()!=null)
            userDTO1.setUsername(userDTOFromCall.getUsername());
        if(userDTOFromCall.getPassword_hash()!=null)
            userDTO1.setPassword_hash(userDTOFromCall.getPassword_hash());
        return userDTO1;
    }
}
