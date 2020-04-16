import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

    @Test
    public void analyzeCarByParams_millageNull_throwsIllegalArgumentException() {

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = null;
        CarService service = new CarService();

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.analyzeCarByParams(treadThickness, fuelUsage, carMillage));
    }

    @Test
    public void analyzeCarByParams_allValuesOk_resultTrue() {

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = 15000;
        CarService service = new CarService();

        //when
        boolean result = service.analyzeCarByParams(treadThickness, fuelUsage, carMillage);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void analyzeCarByParams_carMillageNotOk_resultFalse() {

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = 21000;
        CarService service = new CarService();

        //when
        boolean result = service.analyzeCarByParams(treadThickness, fuelUsage, carMillage);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    public void analyzeCarByParams_millageLessThanZero_throwsIllegalArgumentException() {

        //given
        Integer treadThickness = 3;
        Integer fuelUsage = 5;
        Integer carMillage = -1;
        CarService service = new CarService();

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.analyzeCarByParams(treadThickness, fuelUsage, carMillage));
    }

    @Test
    public void analyzeCarByParams_valuesEqualToMinOrMax_resultFalse() {

        //given
        Integer treadThickness = 2;
        Integer fuelUsage = 14;
        Integer carMillage = 0;
        CarService service = new CarService();

        //when
        boolean result = service.analyzeCarByParams(treadThickness, fuelUsage, carMillage);

        //then
        Assertions.assertFalse(result);
    }
}
