package to.us.moodmessenger.MoodMessenger.services;

import to.us.moodmessenger.MoodMessenger.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> listUsers();
    User getuserById(UUID id);
    User saveNewUser(User beer);
    User updateUser(UUID id,User user);
    User patchUser(UUID id,User user);
}
