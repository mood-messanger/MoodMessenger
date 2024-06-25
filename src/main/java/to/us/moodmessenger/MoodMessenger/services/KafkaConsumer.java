package to.us.moodmessenger.MoodMessenger.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-messages", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Received Message: " + message);
    }
}