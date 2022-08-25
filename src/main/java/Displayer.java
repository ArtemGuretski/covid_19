import dto.CurrentCasesInformationDTO;
import dto.NewConfirmedCasesDTO;

/**
 * Created by Artem Guretski
 *
 * Class display information about covid cases by country
 */
public class Displayer {

    public void displayCasesInformation(CurrentCasesInformationDTO currentCasesInformationDTO){
        System.out.println("Country: " + currentCasesInformationDTO.getCountry());
        System.out.println("Confirmed: " + currentCasesInformationDTO.getConfirmed());
        System.out.println("Recovered: " + currentCasesInformationDTO.getRecovered());
        System.out.println("Deaths: " + currentCasesInformationDTO.getDeaths());
        System.out.println("Vaccinated level in %: " + currentCasesInformationDTO.getVaccinatedLevel());
    }

    public void displayNewConfirmedCases(NewConfirmedCasesDTO newConfirmedCasesDTO){
        System.out.println("Country: " + newConfirmedCasesDTO.getCountry());
        System.out.println("Confirmed cases " + newConfirmedCasesDTO.getDate() + ": " + newConfirmedCasesDTO.getNewCases());
    }
}
