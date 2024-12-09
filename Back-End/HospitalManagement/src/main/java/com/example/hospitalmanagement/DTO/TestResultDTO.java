package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TestResultDTO {

    private Long id;

    private Long labTestId;

    private String resultFilePath;

    private LocalDateTime uploadedAt;
}
