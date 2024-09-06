package com.example.Job_Board.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobsDto {
    private Long id;
    private String title;
    private String type;
    private String level;
    private String city;
    private String country;
    private LocalDate posted;
    private LocalDate updated;
    private String description;
    private String responsibility;
    private String qualification;
    private String prefered_Qualification;
    private double min_salary;
    private double max_salary;
    private String benefits;
    private String available;
    private List<ApplicationDtoForJobs> applications;
}
