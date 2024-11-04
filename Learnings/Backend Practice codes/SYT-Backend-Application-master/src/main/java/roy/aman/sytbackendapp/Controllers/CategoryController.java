package roy.aman.sytbackendapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.sytbackendapp.Services.CategoryServices;
import roy.aman.sytbackendapp.Utility.CategoryDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app/categories")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    // POST
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto cat = this.categoryServices.createCategory(categoryDto);

        return new ResponseEntity<>(cat, HttpStatus.CREATED);

    }

    //PUT
    @PutMapping("/{cId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer cId) {
        CategoryDto updatedCat = this.categoryServices.updateCategory(categoryDto, cId);

        return new ResponseEntity<>(updatedCat, HttpStatus.CREATED);
    }

    //GET
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryDetails(@PathVariable("categoryId") Integer cId) {
        CategoryDto cat = this.categoryServices.getCategory(cId);

        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategoryDetails() {
        List<CategoryDto> categories = this.categoryServices.getCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    // DELETE
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer cId) {
        this.categoryServices.deleteCategory(cId);

        return new ResponseEntity<>("Your category is deleted successfully!", HttpStatus.OK);
    }


}
