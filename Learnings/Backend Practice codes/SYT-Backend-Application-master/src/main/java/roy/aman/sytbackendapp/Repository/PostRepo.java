package roy.aman.sytbackendapp.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roy.aman.sytbackendapp.Entities.Category;
import roy.aman.sytbackendapp.Entities.Post;
import roy.aman.sytbackendapp.Entities.User;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByAuthor(User user);// give local identifier name not it's class

    Page<Post> findByCategory(Category category, Pageable p);

//	@Query("select p from Post p where p.title like :key")
//	List<Post> searchByTitle(@Param("key") String title);


}