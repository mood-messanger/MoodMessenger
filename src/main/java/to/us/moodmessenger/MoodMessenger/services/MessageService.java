package to.us.moodmessenger.MoodMessenger.services;

import to.us.moodmessenger.MoodMessenger.model.MessageDTO;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    List<MessageDTO> getMessagesforSenderAndReceiver(UUID sender_id, UUID receiver_id);

    MessageDTO getMessagebyId(UUID message_id);
    List<MessageDTO> getAllMessages();
    MessageDTO saveMessage(MessageDTO message);
    List<MessageDTO> getAllMessagesRead();
}
