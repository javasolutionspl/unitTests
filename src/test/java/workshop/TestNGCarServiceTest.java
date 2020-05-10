package workshop;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import workshop.CarDetails;
import workshop.CarDiagnosticResult;
import workshop.CarService;
import java.util.ArrayList;
import java.util.List;

public class TestNGCarServiceTest {

    @Test(dataProvider = "data")
    public void analyzeCars_dataFromDataProvider_resultFromDataProvider(List<CarDetails> carsDetail, List<CarDiagnosticResult> expectedResults) {

        //given
        CarService carService = new CarService();

        //when
        List<CarDiagnosticResult> results = carService.analyzeCars(carsDetail);

        //then
        Assert.assertEquals(results, expectedResults);
    }

    @DataProvider(name = "data")
    private Object[][] data() {

        return new Object[][] {
                {createCarDetailsFirstCase(), createExpectedResultsFirstCase()},
                {createCarDetailsFalseCase(), createExpectedResultsFalseCase()}
        };
    }

    private List<CarDiagnosticResult> createExpectedResultsFirstCase() {

        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1", true));
        results.add(new CarDiagnosticResult("2", false));
        results.add(new CarDiagnosticResult("3", true));
        return results;
    }

    private List<CarDiagnosticResult> createExpectedResultsFalseCase() {

        List<CarDiagnosticResult> results = new ArrayList<>();
        results.add(new CarDiagnosticResult("1", false));
        results.add(new CarDiagnosticResult("2", false));
        results.add(new CarDiagnosticResult("3", false));
        results.add(new CarDiagnosticResult("4", false));
        results.add(new CarDiagnosticResult("5", false));
        results.add(new CarDiagnosticResult("6", false));
        return results;
    }

    private List<CarDetails> createCarDetailsFirstCase() {

        List<CarDetails> carsDetails = new ArrayList<>();
        carsDetails.add(createCarDetails("1", 3, 3, 3));
        carsDetails.add(createCarDetails("2", 3, 300000, 3));
        carsDetails.add(createCarDetails("3", 3, 3, 3));
        return carsDetails;
    }

    private List<CarDetails> createCarDetailsFalseCase() {

        List<CarDetails> carsDetails = new ArrayList<>();
        carsDetails.add(createCarDetails("1", 3, 15, 3));
        carsDetails.add(createCarDetails("2", 3, 3, 25000));
        carsDetails.add(createCarDetails("3", 3, 16, 300000));
        carsDetails.add(createCarDetails("4", 300000000, 3, 3));
        carsDetails.add(createCarDetails("5", 33333333, 30, 30000));
        carsDetails.add(createCarDetails("6", 3, 32, 3));
        return carsDetails;
    }

    private CarDetails createCarDetails(String id, Integer treadThickness, Integer fuelUsage, Integer carMillage) {

        CarDetails carDetails = new CarDetails();
        carDetails.setId(id);
        carDetails.setTreadThickness(treadThickness);
        carDetails.setFuelUsage(fuelUsage);
        carDetails.setCarMillage(carMillage);
        return carDetails;
    }
}
