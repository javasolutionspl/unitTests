package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherWorkshopCarDetailsService {

    public List<OtherWorkshopCarDetailsDTO> findCarDetailsToAnalyze() {

        //DB operations
        return new ArrayList<>(dbContent());
    }

    private List<OtherWorkshopCarDetailsDTO> dbContent() {

        return Arrays.asList(create(1, 3, 5, 10000, "BMW"),
                create(2, 2, 10, 15000, "OPEL"));
    }

    private OtherWorkshopCarDetailsDTO create(Integer id, Integer treadThickness, Integer fuelUsage, Integer carMillage, String brand) {

        OtherWorkshopCarDetailsDTO result = new OtherWorkshopCarDetailsDTO();
        result.setId(id);
        result.setBrand(brand);
        result.setTreadThickness(treadThickness);
        result.setFuelUsage(fuelUsage);
        result.setCarMillage(carMillage);
        return result;
    }
}
