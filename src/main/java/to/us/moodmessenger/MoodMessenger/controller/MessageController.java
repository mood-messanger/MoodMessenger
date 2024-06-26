package to.us.moodmessenger.MoodMessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import to.us.moodmessenger.MoodMessenger.entities.Message;
import to.us.moodmessenger.MoodMessenger.entities.User;
import to.us.moodmessenger.MoodMessenger.model.ConverstationBetween;
import to.us.moodmessenger.MoodMessenger.model.MessageDTO;
import to.us.moodmessenger.MoodMessenger.model.UserDTO;
import to.us.moodmessenger.MoodMessenger.services.KafkaProducer;
import to.us.moodmessenger.MoodMessenger.services.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping
    public List<MessageDTO> getMessages() {
        return messageService.getAllMessages();
    }
    //.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic user-messages
    @PostMapping
    public MessageDTO postMessage(@RequestBody MessageDTO messageDTO) {
        kafkaProducer.sendMessage("user-messages",messageDTO.getMessage());
        MessageDTO message =  messageService.saveMessage(messageDTO);
        kafkaProducer.sendMessage("user-messages",message.toString());

        return message;
    }
    @GetMapping("/read")
    public List<MessageDTO> getAllMessagesRead(){
        return messageService.getAllMessagesRead();
    }
    @PostMapping("/conversation")
    public List<MessageDTO> getAllMessagesConversation(@RequestBody ConverstationBetween converstationBetween){
        return messageService.getMessagesforSenderAndReceiver(converstationBetween.getSender_id(),converstationBetween.getReceiver_id());
    }
    @PostMapping("/recentchats")
    public List<MessageDTO> getAllRecentChats(@RequestBody UserDTO user){
        return messageService.getAllRecentChats(user.getId());
    }
}
