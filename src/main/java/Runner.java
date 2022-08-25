import exception.IncorrectCountryNameException;
import service.CovidApiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Artem Guretski
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Enter country please:");

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            String param = bufferedReader.readLine();

            CovidApiService covidApiService = new CovidApiService();
            Displayer displayer = new Displayer();

            displayer.displayCasesInformation(covidApiService.getCurrentCasesInformationDTO(param));
            displayer.displayNewConfirmedCases(covidApiService.getNewConfirmedCases(param));
        } catch (IncorrectCountryNameException e) {
            System.out.println("Incorrect country name");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
