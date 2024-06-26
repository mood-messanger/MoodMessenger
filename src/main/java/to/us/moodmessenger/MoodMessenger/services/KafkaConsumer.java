package to.us.moodmessenger.MoodMessenger.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-messages", groupId = "group_id")
    public void consume(String message) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Received Message: " + message);
    }
}