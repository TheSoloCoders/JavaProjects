package roy.aman.sytbackendapp.Services.Implimentation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.sytbackendapp.Entities.Category;
import roy.aman.sytbackendapp.Exceptions.ResourceNotFoundException;
import roy.aman.sytbackendapp.Repository.CategoryRepo;
import roy.aman.sytbackendapp.Services.CategoryServices;
import roy.aman.sytbackendapp.Utility.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryImp implements CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(category);

        return modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCat = this.categoryRepo.save(category);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        this.categoryRepo.delete(category);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {

        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(cat -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());

        return categoryDtos;
    }
}
