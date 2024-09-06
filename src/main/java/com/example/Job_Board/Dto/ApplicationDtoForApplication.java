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
public class ApplicationDtoForApplication {
    private Long id;
    private String status;
    private LocalDate submitted;
    private JobsDtoForApplication jobs;
    private ApplicantDtoForApplication applicant;
}
