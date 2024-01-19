package com.betting.karakoc.model.dtos;

import lombok.Data;

@Data
public class UserBetEntityDTO {
    private String id;
    private Long userBetRoundId;
    private Long gameEntityId;
    private Long betTeamId;
    private Boolean isGuessCorrect;
    private String oynayanTakimlar;
}
