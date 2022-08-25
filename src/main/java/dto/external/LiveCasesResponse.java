package dto.external;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Guretski
 *
 * external response fo https://covid-api.mmediagroup.fr/v1/cases
 */
public class LiveCasesResponse {
    @SerializedName("All")
    private LiveCasesDTO liveCasesDTO;

    public LiveCasesResponse() {
    }

    public LiveCasesDTO getLiveCasesDTO() {
        return liveCasesDTO;
    }

    public void setLiveCasesDTO(LiveCasesDTO liveCasesDTO) {
        this.liveCasesDTO = liveCasesDTO;
    }
}
