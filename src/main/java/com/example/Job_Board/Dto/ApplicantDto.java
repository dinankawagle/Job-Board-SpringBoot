package com.example.Job_Board.Dto;

import com.example.Job_Board.Entity.Address;
import com.example.Job_Board.Entity.Education;
import com.example.Job_Board.Entity.Experience;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDto {
    private Long id;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String skills;
    private double desiredSalary;
    private Address address;
    private List<Education> education;
    private List<Experience> experience;
    private List<ApplicationDtoForApplicant> applications;
}
