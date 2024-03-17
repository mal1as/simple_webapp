package com.mal1as.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ExtendedResponseDTO {

    private Map<String, Object> data;
    private String response;
    private String request;
}