package to.us.moodmessenger.MoodMessenger.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class MessageDTO {
    private UUID id;
    private UUID sender_id;
    private UUID receiver_id;
    private String message;
    private MessageStatus status;
    private LocalDateTime timestamp;
}
