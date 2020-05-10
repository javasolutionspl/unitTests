package workshop;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class OtherWorkshopCarServiceTest {

    @Test
    public void analyzeOtherWorkshopCars_basicCase_success() {

        //given
        List<CarDetails> carDetails = new ArrayList<>();
        CarService carService = mockCarService();
        CarDetailsConverter converter = mockConverter(carDetails);
        OtherWorkshopCarService service = new OtherWorkshopCarService(carService, converter);

        //when
        service.analyzeOtherWorkshopCars();

        //then
        Mockito.verify(carService).analyzeCars(carDetails);
    }

    private CarService mockCarService() {

        CarService carService = Mockito.mock(CarService.class);
        return carService;
    }

    private CarDetailsConverter mockConverter(List<CarDetails> carDetails) {

        CarDetailsConverter converter = Mockito.mock(CarDetailsConverter.class);
        Mockito.when(converter.convertAll()).thenReturn(carDetails);
        return converter;
    }
}
