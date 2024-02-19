package com.betting.karakoc.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteBetRequest {
    @NotBlank private Long betroundId; @NotBlank private Long userbetroundId;@NotBlank private String betId;
    @NotBlank private String adminToken;
}
