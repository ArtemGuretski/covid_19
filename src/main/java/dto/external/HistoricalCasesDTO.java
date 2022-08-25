package dto.external;

import java.util.TreeMap;

/**
 * Created by Artem Guretski
 *
 * internal response fo https://covid-api.mmediagroup.fr/v1/history
 */
public class HistoricalCasesDTO {
    private String country;
    private TreeMap<String, Integer> dates;

    public HistoricalCasesDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TreeMap<String, Integer> getDates() {
        return dates;
    }

    public void setDates(TreeMap<String, Integer> dates) {
        this.dates = dates;
    }
}
