package roy.aman.sytbackendapp.Services;

import roy.aman.sytbackendapp.Utility.CategoryDto;

import java.util.List;

public interface CategoryServices {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void deleteCategory(Integer id);

    CategoryDto getCategory(Integer categoryId);

    List<CategoryDto> getCategories();
}
