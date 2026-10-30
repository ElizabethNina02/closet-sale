package coreclosetsale.closet_sale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.models.District;
import coreclosetsale.closet_sale.repositories.DistrictRepository;

@Service 
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

	@Override
	public List<District> getDistrictsByProvinceId(Integer provinceId) {
		return districtRepository.findByProvinceId(provinceId);
	}
}
