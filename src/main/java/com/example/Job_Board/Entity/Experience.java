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

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long experience_id;
    @NotNull(message = "Please enter your job title!!")
    private String job_title;
    @NotNull(message = "Please enter the name of the company!!")
    private String company_name;
    private Date started;
    private Date ended;
    private boolean still_there;
    private String responsibilities;
}
