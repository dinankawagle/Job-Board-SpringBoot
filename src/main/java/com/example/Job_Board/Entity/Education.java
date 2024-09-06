package com.example.Job_Board.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long education_id;
    @NotNull(message = "Please enter your degree!!")
    private String degree;
    @NotNull(message = "Please enter your major!!")
    private String major;
    private String minor;
    private double gpa;
    @NotNull(message = "Please enter your school's name!!")
    private String schoolName;
}
