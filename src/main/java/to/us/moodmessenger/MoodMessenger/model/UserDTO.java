package to.us.moodmessenger.MoodMessenger.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserDTO {
    private UUID id;
    private String username;
    private String password_hash;
    private String email;
    private String bio;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private LocalDateTime lastlogin_date;
    private String status;
    private String location;
    private String phone_number;
}
