package com.example.springelasticsearch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LogSearchRequestDto {
    private String machineName;
    private String machineCode;
}
