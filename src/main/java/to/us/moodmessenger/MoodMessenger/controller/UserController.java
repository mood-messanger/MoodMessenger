package to.us.moodmessenger.MoodMessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;
import to.us.moodmessenger.MoodMessenger.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.listUsers();
    }
    @GetMapping("{userId}")
    public UserDTO getUser(@PathVariable UUID userId){
        return userService.getuserById(userId);
    }
    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDTO userDTO){
        UserDTO savedUserDTO = userService.saveNewUser(userDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "success");
        headers.add("Location","/api/v1/userDTO/"+ userDTO.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping ("{userId}")
    public ResponseEntity updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO){
        UserDTO savedUserDTO = userService.updateUser(userId, userDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "success");
        headers.add("Location","/api/v1/userDTO/"+ userDTO.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PatchMapping("{userId}")
    public ResponseEntity patchUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO){
        UserDTO savedUserDTO = userService.patchUser(userId, userDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "success");
        headers.add("Location","/api/v1/userDTO/"+ userDTO.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

}
