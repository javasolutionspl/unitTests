package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import workshop.CarService;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("data")
    public void analyzeCarByParams_withDataFromMethod_ResultFromData(Integer treadThickness, Integer fuelUsage, Integer carMillage, boolean expectedResult) {

        //given
        CarService service = new CarService();

        //when
        boolean result = service.analyzeCarByParams(treadThickness, fuelUsage, carMillage);

        //then
        Assertions.assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> data() {

        return Stream.of(Arguments.of(3, 5, 1500, true),
                Arguments.of(3, 5, 21000, false),
                Arguments.of(2, 14, 0, false));
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


}
