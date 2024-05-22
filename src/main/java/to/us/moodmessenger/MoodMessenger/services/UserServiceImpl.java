package to.us.moodmessenger.MoodMessenger.services;

import org.springframework.stereotype.Service;
import to.us.moodmessenger.MoodMessenger.model.User;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    Map<UUID,User> userMap = new HashMap<>();

    public UserServiceImpl() {
        User user1 = User.builder()
                .id(UUID.randomUUID())
                .username("username1")
                .password("password1")
                .build();
        User user2 = User.builder()
                .id(UUID.randomUUID())
                .username("username2")
                .password("password2")
                .build();
        User user3 = User.builder()
                .id(UUID.randomUUID())
                .username("username2")
                .password("password3")
                .build();
        userMap.put(user1.getId(),user1);
        userMap.put(user2.getId(),user2);
        userMap.put(user3.getId(),user3);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getuserById(UUID id) {
        return userMap.get(id);
    }

    @Override
    public User saveNewUser(User user) {
        user.setId(UUID.randomUUID());
        return userMap.put(user.getId(),user);

    }

    @Override
    public User updateUser(UUID id,User user) {
       user.setId(id);
       return userMap.put(id,user);
    }

    @Override
    public User patchUser(UUID id, User userFromCall) {
        User user1 = userMap.get(id);
        if(userFromCall.getUsername()!=null)
            user1.setUsername(userFromCall.getUsername());
        if(userFromCall.getPassword()!=null)
            user1.setPassword(userFromCall.getPassword());
        System.out.println(user1);
        System.out.println(userFromCall);
        return user1;
    }
}
