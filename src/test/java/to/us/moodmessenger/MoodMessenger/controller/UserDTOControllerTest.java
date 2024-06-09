package to.us.moodmessenger.MoodMessenger.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;
import to.us.moodmessenger.MoodMessenger.services.UserService;
import to.us.moodmessenger.MoodMessenger.services.UserServiceImpl;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserDTOControllerTest {
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
        UserDTO testUserDTO = userServiceImpl.listUsers().get(0);

        given(userService.getuserById(testUserDTO.getId())).willReturn(testUserDTO);
        System.out.println(testUserDTO);
        mockMvc.perform(get("/api/v1/user/"+ testUserDTO.getId())
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(testUserDTO.getId().toString())))
                .andExpect(jsonPath("$.username", is(testUserDTO.getUsername())));
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