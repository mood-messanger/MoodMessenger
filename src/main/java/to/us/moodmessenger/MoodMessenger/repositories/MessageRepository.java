package to.us.moodmessenger.MoodMessenger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import to.us.moodmessenger.MoodMessenger.entities.Message;
import to.us.moodmessenger.MoodMessenger.model.MessageStatus;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    @Query(value = "SELECT * FROM MESSAGE where status = ?1", nativeQuery = true)
    List<Message> findAllRead(@Param("messagestatus") int messagestatus) ;

    @Query(value = "SELECT * FROM MESSAGE WHERE ((sender_id = ?1 and receiver_id = ?2) or (receiver_id = ?1 and sender_id = ?2)) ORDER BY TIMESTAMP", nativeQuery = true)
    List<Message> conversatiomBetweenSenderAndReceiver(String sender_id, String receiver_id) ;
    @Query(value = "SELECT m.* FROM ( " +
            "    SELECT *, " +
            "           ROW_NUMBER() OVER (PARTITION BY " +
            "                                IF(sender_id = ?1, receiver_id, sender_id) " +
            "                              ORDER BY timestamp DESC) as rn " +
            "    FROM message " +
            "    WHERE sender_id = ?1 OR receiver_id = ?1 " +
            ") m " +
            "WHERE m.rn = 1 " +
            "ORDER BY m.timestamp DESC", nativeQuery = true)
    List<Message> findLatestMessagesByUser( String userId);
}
