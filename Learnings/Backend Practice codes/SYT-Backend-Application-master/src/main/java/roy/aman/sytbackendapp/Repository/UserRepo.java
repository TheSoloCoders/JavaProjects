package roy.aman.sytbackendapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.sytbackendapp.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
