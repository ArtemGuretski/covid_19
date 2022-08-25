package dto.external;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Guretski
 *
 * external response fo https://covid-api.mmediagroup.fr/v1/history
 */
public class HistoricalCasesResponse {
    @SerializedName("All")
    HistoricalCasesDTO historicalCasesDTO;

    public HistoricalCasesResponse() {
    }

    public HistoricalCasesDTO getHistoricalCasesDTO() {
        return historicalCasesDTO;
    }

    public void setHistoricalCasesDTO(HistoricalCasesDTO historicalCasesDTO) {
        this.historicalCasesDTO = historicalCasesDTO;
    }
}
