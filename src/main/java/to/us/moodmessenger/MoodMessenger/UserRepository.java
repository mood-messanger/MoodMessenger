package to.us.moodmessenger.MoodMessenger;

import org.springframework.data.jpa.repository.JpaRepository;
import to.us.moodmessenger.MoodMessenger.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {
}
