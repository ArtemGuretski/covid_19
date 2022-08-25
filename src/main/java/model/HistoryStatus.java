package model;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Artem Guretski
 */
public enum HistoryStatus {
    CONFIRMED("Confirmed"),
    DEATHS("Deaths");

    private String status;

    HistoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static Optional<HistoryStatus> get(String status){
        return Arrays.stream(HistoryStatus.values())
                .filter(s -> s.status.equals(status))
                .findFirst();
    }
}
