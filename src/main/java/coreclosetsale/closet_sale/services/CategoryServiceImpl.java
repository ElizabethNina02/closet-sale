package coreclosetsale.closet_sale.services;
import java.util.List;
import coreclosetsale.closet_sale.models.Category;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.repositories.CategoryRepository;

@Service 
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
}
