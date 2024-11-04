package roy.aman.sytbackendapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.sytbackendapp.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
