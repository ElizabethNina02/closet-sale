package coreclosetsale.closet_sale.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coreclosetsale.closet_sale.models.District;
import coreclosetsale.closet_sale.services.DistrictService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping ("/api/districts")
@CrossOrigin(origins = "http://localhost:5173") 
@Tag (name = "Distritos", description = "Operaciones relacionadas con la gestión de departamentos")

public class DistrictController {
    private final DistrictService service;

    public DistrictController(DistrictService service) {
        this.service = service;
    }

    
    @GetMapping("/{id}")
    public List<District> getDistrictsByProvinceId(@PathVariable Integer id) {
        return service.getDistrictsByProvinceId(id);
    }
}
