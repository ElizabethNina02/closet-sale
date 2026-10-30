package coreclosetsale.closet_sale.services;

import java.util.List;

import coreclosetsale.closet_sale.models.District;

public interface DistrictService {
    List<District> getDistrictsByProvinceId (Integer id);
}
