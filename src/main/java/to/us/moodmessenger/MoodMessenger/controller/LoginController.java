package to.us.moodmessenger.MoodMessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import to.us.moodmessenger.MoodMessenger.model.LoginDTO;
import to.us.moodmessenger.MoodMessenger.services.LoginService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping
    public String login(@RequestBody LoginDTO loginDTO) {

        return loginService.login(loginDTO);

    }

}
