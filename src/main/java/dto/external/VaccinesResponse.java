package dto.external;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Guretski
 *
 * external response fo https://covid-api.mmediagroup.fr/v1/vaccines
 */
public class VaccinesResponse {
    @SerializedName("All")
    private VaccinesDTO vaccinesDTO;

    public VaccinesResponse() {
    }

    public VaccinesDTO getVaccinesDTO() {
        return vaccinesDTO;
    }

    public void setVaccinesDTO(VaccinesDTO vaccinesDTO) {
        this.vaccinesDTO = vaccinesDTO;
    }
}
