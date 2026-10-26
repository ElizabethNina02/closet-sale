package coreclosetsale.closet_sale.services;

import java.util.List;
import java.util.UUID;

import coreclosetsale.closet_sale.models.District;

public interface DistrictService {
    List<District> getDistrictsByDepartmentId (Integer id);
}
