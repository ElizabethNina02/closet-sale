package coreclosetsale.closet_sale.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coreclosetsale.closet_sale.models.Province;
import coreclosetsale.closet_sale.services.ProvinceService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping ("/api/provinces")
@CrossOrigin (origins = "http://localhost:5173") 
@Tag (name = "Provincias", description = "Operaciones relacionadas con la gestión de provincias")

public class ProvinceController {
    private final ProvinceService service;

    public ProvinceController(ProvinceService service) {
        this.service = service;
    }

    
    @GetMapping("/{id}")
    public List<Province> getProvincesByDepartmentId(@PathVariable Integer id) {
        return service.getProvincesByDepartmentId(id);
    }
}
