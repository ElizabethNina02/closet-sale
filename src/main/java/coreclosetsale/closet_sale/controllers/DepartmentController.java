package coreclosetsale.closet_sale.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coreclosetsale.closet_sale.models.Department;
import coreclosetsale.closet_sale.services.CategoryService;
import coreclosetsale.closet_sale.services.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping ("/api/departments")
@CrossOrigin(origins = "http://localhost:5173") 
@Tag (name = "Departamentos", description = "Operaciones relacionadas con la gestión de departamentos")

public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    
    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }
}
