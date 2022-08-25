package dto;

import java.util.Objects;

/**
 * Created by Artem Guretski
 */
public class CurrentCasesInformationDTO {
    private String country;
    private int confirmed;
    private int recovered;
    private int deaths;
    private double vaccinatedLevel;

    public CurrentCasesInformationDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public double getVaccinatedLevel() {
        return vaccinatedLevel;
    }

    public void setVaccinatedLevel(double vaccinatedLevel) {
        this.vaccinatedLevel = vaccinatedLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCasesInformationDTO that = (CurrentCasesInformationDTO) o;
        return confirmed == that.confirmed && recovered == that.recovered && deaths == that.deaths && Double.compare(that.vaccinatedLevel, vaccinatedLevel) == 0 && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, confirmed, recovered, deaths, vaccinatedLevel);
    }

    @Override
    public String toString() {
        return "dto.CurrentCasesInformationDTO{" +
                "country='" + country + '\'' +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", vaccinatedLevel=" + vaccinatedLevel +
                '}';
    }
}
