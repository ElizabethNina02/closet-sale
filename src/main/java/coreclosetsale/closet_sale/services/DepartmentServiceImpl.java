package coreclosetsale.closet_sale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.models.Department;
import coreclosetsale.closet_sale.repositories.CategoryRepository;
import coreclosetsale.closet_sale.repositories.DepartmentRepository;

@Service 
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
}
