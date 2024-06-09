package to.us.moodmessenger.MoodMessenger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import to.us.moodmessenger.MoodMessenger.model.LoginDTO;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;
import to.us.moodmessenger.MoodMessenger.utils.PasswordUtils;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Override
    public String login(LoginDTO loginDTO) {
        UserDTO userDTO = userService.getuserByUsername(loginDTO.getUsername());
        if (userDTO != null) {
            return PasswordUtils.checkPassword(loginDTO.getPassword(),userDTO.getPassword_hash()) ? "Login Sucessfull" : "Incorrect Password";
        }
        return "User not found";
    }
}
