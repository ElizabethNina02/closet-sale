package coreclosetsale.closet_sale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import coreclosetsale.closet_sale.models.Province;
import coreclosetsale.closet_sale.repositories.ProvinceRepository;

@Service 
public class ProvinceServiceImpl implements ProvinceService{


    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @Override
    public List<Province> getProvincesByDepartmentId(Integer id) {
        return provinceRepository.findByDepartmentId(id);
    }
    
}
