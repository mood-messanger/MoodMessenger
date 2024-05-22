package to.us.moodmessenger.MoodMessenger.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import to.us.moodmessenger.MoodMessenger.model.User;
import to.us.moodmessenger.MoodMessenger.services.UserService;
import to.us.moodmessenger.MoodMessenger.services.UserServiceImpl;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockBean
    UserService userService;

    UserServiceImpl userServiceImpl =new UserServiceImpl();
    @Autowired
    MockMvc mockMvc;
//    @Test
//    void testgetUser() throws Exception {
//        mockMvc.perform(get("/api/v1/user")
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk());
//    }


    @Test
    void getUserById() throws Exception {
        User testUser = userServiceImpl.listUsers().get(0);

        given(userService.getuserById(testUser.getId())).willReturn(testUser);
        System.out.println(testUser);
        mockMvc.perform(get("/api/v1/user/"+testUser.getId())
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(testUser.getId().toString())))
                .andExpect(jsonPath("$.username", is(testUser.getUsername())));
    }
    @Test
    void testListBeers() throws Exception {
        given(userService.listUsers()).willReturn(userServiceImpl.listUsers());
        mockMvc.perform(get("/api/v1/user")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

}