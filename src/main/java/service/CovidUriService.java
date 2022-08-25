package service;

import model.Country;
import model.HistoryStatus;

/**
 * Created by Artem Guretski
 *
 * Class build URI with params
 */
public class CovidUriService {
    private static final String URI = "https://covid-api.mmediagroup.fr/v1";
    private static final String DATA_TYPE_CASES = "cases";
    private static final String DATA_TYPE_HISTORY = "history";
    private static final String DATA_TYPE_VACCINES = "vaccines";

    public static final String HEADER_NAME_COUNTRY = "country";
    public static final String HEADER_NAME_STATUS = "status";

    public String getConfirmedHistoryUri(Country country) {
        return getHistoryUri(country, HistoryStatus.CONFIRMED);
    }

    public String getCasesUri(Country country) {
        String resultUri = getUri(DATA_TYPE_CASES);
        resultUri = addCountry(resultUri, country);

        return resultUri;
    }

    public String getHistoryUri(Country country, HistoryStatus status) {
        String resultUri = getUri(DATA_TYPE_HISTORY);
        resultUri = addCountry(resultUri, country);
        resultUri = addStatus(resultUri, status);

        return resultUri;
    }

    public String getVaccinesUri(Country country) {
        String resultUri = getUri(DATA_TYPE_VACCINES);
        resultUri = addCountry(resultUri, country);

        return resultUri;
    }

    private String getUri(String dataType) {
        return URI + "/" + dataType;
    }

    private String addCountry(String uri, Country country) {
        return addSeparator(uri).concat("country=").concat(country.getName());
    }

    private String addStatus(String uri, HistoryStatus status) {
        return addSeparator(uri).concat("status=").concat(status.getStatus());
    }

    private String addSeparator(String uri) {
        if(!uri.contains("?")) {
            return uri.concat("?");
        } else {
            return uri.concat("&");
        }
    }
}

