package workshop;

import java.util.List;

public class OtherWorkshopCarService {

    private CarService carService;

    private CarDetailsConverter converter;

    public OtherWorkshopCarService(CarService carService, CarDetailsConverter converter) {

        this.carService = carService;
        this.converter = converter;
    }

    public List<CarDiagnosticResult> analyzeOtherWorkshopCars() {

        List<CarDetails> toAnalyze = converter.convertAll();
        return carService.analyzeCars(toAnalyze);
    }
}
