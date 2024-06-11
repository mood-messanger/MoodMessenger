package to.us.moodmessenger.MoodMessenger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import to.us.moodmessenger.MoodMessenger.entities.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {
}
