package to.us.moodmessenger.MoodMessenger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ConverstationBetween {
    private UUID sender_id;
    private UUID receiver_id;
}
