package com.betting.karakoc.models.dtos;


import com.betting.karakoc.models.real.Team;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameEntityDTO {
    private String id;
    private String betRoundId;
    private List<Team> teams = new ArrayList<>();
}
