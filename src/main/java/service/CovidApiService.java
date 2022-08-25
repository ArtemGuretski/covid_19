package service;

import dto.CurrentCasesInformationDTO;
import dto.NewConfirmedCasesDTO;
import dto.external.HistoricalCasesDTO;
import dto.external.HistoricalCasesResponse;
import dto.external.LiveCasesDTO;
import dto.external.LiveCasesResponse;
import dto.external.VaccinesDTO;
import dto.external.VaccinesResponse;
import exception.IncorrectCountryNameException;
import model.Country;
import model.HistoryStatus;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import util.GsonParser;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Artem Guretski
 */
public class CovidApiService {
    CloseableHttpClient httpClient = HttpClients.createDefault();

    public CurrentCasesInformationDTO getCurrentCasesInformationDTO(String country) throws IncorrectCountryNameException {
        CurrentCasesInformationDTO currentCasesInformationDTO = new CurrentCasesInformationDTO();
        Optional<Country> optionalCountry = Country.get(country);

        if (optionalCountry.isEmpty()) {
            throw new IncorrectCountryNameException();
        }

        if (optionalCountry.isPresent()) {
            try {
                Country enumCountry = optionalCountry.get();
                CovidUriService covidUriService = new CovidUriService();

                String casesUri = covidUriService.getCasesUri(enumCountry);
                HttpGet casesRequest = createRequest(casesUri, enumCountry);

                CloseableHttpResponse casesHttpResponse = httpClient.execute(casesRequest);

                HttpEntity casesEntity = casesHttpResponse.getEntity();

                String vaccinesUri = covidUriService.getVaccinesUri(enumCountry);
                HttpGet vaccinesRequest = createRequest(vaccinesUri, enumCountry);

                CloseableHttpResponse vaccinesHttpResponse = httpClient.execute(vaccinesRequest);

                HttpEntity vaccinesEntity = vaccinesHttpResponse.getEntity();

                LiveCasesResponse liveCasesResponse = GsonParser.parse(EntityUtils.toString(casesEntity), LiveCasesResponse.class);
                LiveCasesDTO liveCasesDTO = liveCasesResponse.getLiveCasesDTO();
                VaccinesResponse vaccinesResponse = GsonParser.parse(EntityUtils.toString(vaccinesEntity), VaccinesResponse.class);
                VaccinesDTO vaccinesDTO = vaccinesResponse.getVaccinesDTO();

                buildCurrentCasesInformationDTO(currentCasesInformationDTO, liveCasesDTO, vaccinesDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return currentCasesInformationDTO;
    }

    public NewConfirmedCasesDTO getNewConfirmedCases(String country) throws IncorrectCountryNameException {
        NewConfirmedCasesDTO newConfirmedCasesDTO = new NewConfirmedCasesDTO();
        Optional<Country> optionalCountry = Country.get(country);

        if (optionalCountry.isEmpty()) {
            throw new IncorrectCountryNameException();
        }

        try {
            Country enumCountry = optionalCountry.get();
            CovidUriService covidUriService = new CovidUriService();

            String historyUri = covidUriService.getConfirmedHistoryUri(enumCountry);
            HttpGet historyRequest = createHistoryRequest(historyUri, enumCountry);

            CloseableHttpResponse historyHttpResponse = httpClient.execute(historyRequest);

            HttpEntity historyEntity = historyHttpResponse.getEntity();

            HistoricalCasesResponse historicalCasesResponse = GsonParser.parse(EntityUtils.toString(historyEntity), HistoricalCasesResponse.class);
            HistoricalCasesDTO historicalCasesDTO = historicalCasesResponse.getHistoricalCasesDTO();

            buildCurrentCasesInformationDTO(newConfirmedCasesDTO, historicalCasesDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newConfirmedCasesDTO;
    }

    private HttpGet createRequest(String uri, Country enumCountry) {
        HttpGet request = new HttpGet(uri);
        request.addHeader(CovidUriService.HEADER_NAME_COUNTRY, enumCountry.getName());

        return request;
    }

    private HttpGet createHistoryRequest(String uri, Country enumCountry) {
        HttpGet request = createRequest(uri, enumCountry);
        request.addHeader(CovidUriService.HEADER_NAME_STATUS, HistoryStatus.CONFIRMED.getStatus());

        return request;
    }

    private void buildCurrentCasesInformationDTO(CurrentCasesInformationDTO currentCasesInformationDTO, LiveCasesDTO liveCasesDTO, VaccinesDTO vaccinesDTO) {
        currentCasesInformationDTO.setCountry(vaccinesDTO.getCountry());
        currentCasesInformationDTO.setConfirmed(liveCasesDTO.getConfirmed());
        currentCasesInformationDTO.setRecovered(liveCasesDTO.getRecovered());
        currentCasesInformationDTO.setDeaths(liveCasesDTO.getDeaths());
        double vaccinatedLevel = (double) vaccinesDTO.getPeopleVaccinated() / vaccinesDTO.getPopulation() * 100;
        currentCasesInformationDTO.setVaccinatedLevel(vaccinatedLevel);
    }

    private void buildCurrentCasesInformationDTO(NewConfirmedCasesDTO newConfirmedCasesDTO, HistoricalCasesDTO historicalCasesDTO) {
        newConfirmedCasesDTO.setCountry(historicalCasesDTO.getCountry());
        String lastDate = historicalCasesDTO.getDates().lastKey();
        newConfirmedCasesDTO.setDate(lastDate);
        newConfirmedCasesDTO.setNewCases(historicalCasesDTO.getDates().get(lastDate));
    }
}
