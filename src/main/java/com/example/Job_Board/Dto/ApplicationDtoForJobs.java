package com.example.Job_Board.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDtoForJobs {
    private Long id;
    private String status;
    private LocalDate submitted;
    private ApplicantDtoForApplication applicant;
}
