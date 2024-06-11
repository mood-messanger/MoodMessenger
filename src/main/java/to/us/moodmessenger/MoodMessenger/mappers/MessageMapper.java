package to.us.moodmessenger.MoodMessenger.mappers;

import org.mapstruct.Mapper;
import to.us.moodmessenger.MoodMessenger.entities.Message;
import to.us.moodmessenger.MoodMessenger.model.MessageDTO;

@Mapper
public interface MessageMapper {
    MessageDTO messageToMessageDTO(Message message);
    Message messageDTOToMessage(MessageDTO messageDTO);
}
