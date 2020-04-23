import java.util.ArrayList;
import java.util.List;

public class CarService {

    public List<CarDiagnosticResult> analyzeCars(List<CarDetails> carsDetails) {

        List<CarDiagnosticResult> results = new ArrayList<>();
        carsDetails.forEach(details -> {

            boolean analyzeResult = analyzeSingle(details);
            results.add(new CarDiagnosticResult(details.getId(), analyzeResult));
        });
        return results;
    }

    private boolean analyzeSingle(CarDetails carDetails) {

        Integer treadThickness = carDetails.getTreadThickness();
        Integer fuelUsage = carDetails.getFuelUsage();
        Integer carMillage = carDetails.getCarMillage();
        return analyzeCarByParams(treadThickness, fuelUsage, carMillage);
    }

    boolean analyzeCarByParams(Integer treadThickness, Integer fuelUsage, Integer carMillage) {

        boolean millageNull = null == carMillage;
        boolean fuelUsageNull = null == fuelUsage;
        boolean treadThicknessNull = null == treadThickness;
        if (millageNull || fuelUsageNull || treadThicknessNull) {

            throw new IllegalArgumentException("Car details can not be null");
        }
        boolean isMillageCorrect = isCorrect(carMillage, ParamValues.CAR_MILLAGE);
        boolean isFuelUsageCorrect = isCorrect(fuelUsage, ParamValues.FUEL_USAGE);
        boolean isTreadThicknessCorrect = isCorrect(treadThickness, ParamValues.TREAD_THICKNESS);
        if (isMillageCorrect && isFuelUsageCorrect && isTreadThicknessCorrect) {

            return true;
        }
        return false;
    }

    private boolean isCorrect(Integer value, ParamValues validValues) {

        if (value < 0) {

            throw new IllegalArgumentException("Incorrect value");
        }
        Integer maxValue = validValues.getMaxValue();
        Integer minValue = validValues.getMinValue();
        if (value > minValue && value < maxValue) {

            return true;
        }
        return false;
    }
}
