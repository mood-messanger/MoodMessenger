package to.us.moodmessenger.MoodMessenger.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import to.us.moodmessenger.MoodMessenger.entities.Message;
import to.us.moodmessenger.MoodMessenger.mappers.MessageMapper;
import to.us.moodmessenger.MoodMessenger.model.MessageDTO;
import to.us.moodmessenger.MoodMessenger.model.MessageStatus;
import to.us.moodmessenger.MoodMessenger.repositories.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MessageServiceJPAImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageMapper messageMapper ;

    @Override
    public List<MessageDTO> getMessagesforSenderAndReceiver(UUID sender_id, UUID receiver_id) {

        return List.of();
    }
    @Override
    public MessageDTO getMessagebyId(UUID message_id) {
     return messageMapper.messageToMessageDTO( messageRepository.findById(message_id).orElse(null));
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        List<Message> messageList = messageRepository.findAll();
        return messageList.stream().map(messageMapper::messageToMessageDTO).toList();
    }

    @Override
    public MessageDTO saveMessage(MessageDTO messageDTO) {
        messageDTO.setTimestamp(LocalDateTime.now());
        return messageMapper.messageToMessageDTO(messageRepository.save(messageMapper.messageDTOToMessage(messageDTO)));
    }

    @Override
    public List<MessageDTO> getAllMessagesRead() {
        List<Message> readMessages = messageRepository.findAllRead(MessageStatus.READ.ordinal());
        return readMessages.stream().map(messageMapper::messageToMessageDTO).toList();
    }

}
