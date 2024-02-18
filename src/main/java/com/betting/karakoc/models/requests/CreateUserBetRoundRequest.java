package com.betting.karakoc.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class CreateUserBetRoundRequest {

    @NotBlank
    private Long betRoundEntityId;
    @NotBlank
    private String userToken;

}
