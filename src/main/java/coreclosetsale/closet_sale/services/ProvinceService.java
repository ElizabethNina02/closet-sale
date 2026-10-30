package coreclosetsale.closet_sale.services;

import java.util.List;

import coreclosetsale.closet_sale.models.Province;

public interface ProvinceService {
    List<Province> getProvincesByDepartmentId (Integer id);
}
