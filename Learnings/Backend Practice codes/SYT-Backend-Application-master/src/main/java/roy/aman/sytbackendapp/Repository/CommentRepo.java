package roy.aman.sytbackendapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.sytbackendapp.Entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {


}
