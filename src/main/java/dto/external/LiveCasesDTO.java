package dto.external;

/**
 * Created by Artem Guretski
 *
 * internal response fo https://covid-api.mmediagroup.fr/v1/cases
 */
public class LiveCasesDTO {
    private int confirmed;
    private int recovered;
    private int deaths;

    public LiveCasesDTO() {
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
