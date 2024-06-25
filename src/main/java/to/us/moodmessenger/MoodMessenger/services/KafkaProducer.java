package to.us.moodmessenger.MoodMessenger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        System.out.println("topic:"+topic+"\t\nsendMessage: " + message);
        kafkaTemplate.send(topic, message);
    }
}