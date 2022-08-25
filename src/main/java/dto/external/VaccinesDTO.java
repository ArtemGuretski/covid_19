package dto.external;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Guretski
 *
 * internal response fo https://covid-api.mmediagroup.fr/v1/vaccines
 */
public class VaccinesDTO {
    private String country;

    @SerializedName("people_vaccinated")
    private int peopleVaccinated;

    private int population;

    public VaccinesDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public void setPeopleVaccinated(int peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
