package dto;

/**
 * Created by Artem Guretski
 */
public class NewConfirmedCasesDTO {
    private String country;
    private String date;
    private int newCases;

    public NewConfirmedCasesDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }
}
