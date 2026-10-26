package coreclosetsale.closet_sale.services;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.models.District;
import coreclosetsale.closet_sale.repositories.DepartmentRepository;
import coreclosetsale.closet_sale.repositories.DistrictRepository;

@Service 
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

	@Override
	public List<District> getDistrictsByDepartmentId(Integer departmentId) {
		return districtRepository.findByDepartmentId(departmentId);
	}
}
