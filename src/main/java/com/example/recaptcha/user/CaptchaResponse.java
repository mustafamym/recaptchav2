package com.example.recaptcha.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CaptchaResponse {


    @JsonProperty("success")
    private boolean success;

    @JsonProperty("score")
    private double score;

    @JsonProperty("action")
    private String action;

    @JsonProperty("challenge_ts")
    private LocalDateTime challengeTimestamp;

    @JsonProperty("hostname")
    private String hostname;

    @JsonProperty("error-codes")
    private List<String> errorCodes;

}