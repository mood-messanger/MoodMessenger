package to.us.moodmessenger.MoodMessenger.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {
    String username;
    String password;
    UUID id;
}
