package service;

import dto.CurrentCasesInformationDTO;
import dto.NewConfirmedCasesDTO;
import exception.IncorrectCountryNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CovidApiServiceTest {
    @Test
    public void test_getCurrentCasesInformationDTO() throws IncorrectCountryNameException {
        CovidApiService service = new CovidApiService();
        String country = "Germany";

        CurrentCasesInformationDTO response = service.getCurrentCasesInformationDTO(country);

        assertEquals(country, response.getCountry());
    }

    @Test
    public void test_getCurrentCasesInformationDTO_IncorrectCountry() {
        CovidApiService service = new CovidApiService();
        String country = "Germanyy";

        IncorrectCountryNameException thrown = Assertions.assertThrows(IncorrectCountryNameException.class, () -> {
            service.getCurrentCasesInformationDTO(country);
        }, "Incorrect country name");

        Assertions.assertEquals("Incorrect country name", thrown.getMessage());
    }

    @Test
    public void test_getNewConfirmedCases() throws IncorrectCountryNameException {
        CovidApiService service = new CovidApiService();
        String country = "Germany";

        NewConfirmedCasesDTO response = service.getNewConfirmedCases(country);

        assertEquals(country, response.getCountry());
    }

    @Test
    public void test_getNewConfirmedCases_IncorrectCountry() {
        CovidApiService service = new CovidApiService();
        String country = "Germanyy";

        IncorrectCountryNameException thrown = Assertions.assertThrows(IncorrectCountryNameException.class, () -> {
            service.getNewConfirmedCases(country);
        }, "Incorrect country name");

        Assertions.assertEquals("Incorrect country name", thrown.getMessage());
    }
}