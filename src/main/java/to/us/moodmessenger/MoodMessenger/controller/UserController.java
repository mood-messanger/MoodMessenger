package to.us.moodmessenger.MoodMessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import to.us.moodmessenger.MoodMessenger.model.User;
import to.us.moodmessenger.MoodMessenger.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> getUsers(){
        return userService.listUsers();
    }
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable UUID userId){
        return userService.getuserById(userId);
    }
    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user){
        User savedUser = userService.saveNewUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "success");
        headers.add("Location","/api/v1/user/"+user.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping ("/user/{userId}")
    public ResponseEntity updateUser(@PathVariable UUID userId, @RequestBody User user){
        User savedUser = userService.updateUser(userId,user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "success");
        headers.add("Location","/api/v1/user/"+user.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PatchMapping("/user/{userId}")
    public ResponseEntity patchUser(@PathVariable UUID userId, @RequestBody User user){
        User savedUser = userService.patchUser(userId,user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "success");
        headers.add("Location","/api/v1/user/"+user.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

}
