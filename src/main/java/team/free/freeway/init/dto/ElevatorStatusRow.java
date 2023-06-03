package team.free.freeway.init.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ElevatorStatusRow {

    @JsonAlias(value = "row")
    private List<ElevatorStatusInfo> elevatorStatusInfoList;
}
