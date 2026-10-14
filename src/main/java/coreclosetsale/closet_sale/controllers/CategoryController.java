package coreclosetsale.closet_sale.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coreclosetsale.closet_sale.models.Category;
import coreclosetsale.closet_sale.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping ("/api/categories")
@Tag (name = "Categorías", description = "Operaciones relacionadas con la gestión de categorías")

public class CategoryController {
     private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }
}
