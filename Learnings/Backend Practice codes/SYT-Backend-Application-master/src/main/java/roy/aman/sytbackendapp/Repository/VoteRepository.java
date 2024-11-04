package roy.aman.sytbackendapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.sytbackendapp.Entities.Post;
import roy.aman.sytbackendapp.Entities.Vote;

import java.util.List;


public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findAllByPost(Post post);

}
