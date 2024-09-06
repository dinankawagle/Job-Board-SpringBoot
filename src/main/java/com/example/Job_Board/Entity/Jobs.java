package com.example.Job_Board.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Please enter a job title!!")
    private String title;
    private String type;
    private String level;
    @NotNull(message = "Please enter a city!!")
    private String city;
    @NotNull(message = "Please enter a country!!")
    private String country;
    private LocalDate posted=LocalDate.now();
    private LocalDate updated=LocalDate.now();
    @NotNull(message = "Please enter a description!!")
    @Column(length = 2000)
    @Size(max = 2000, message = "You have exceeded the size limit")
    private String description;
    @NotNull(message = "Please enter responsibilities in this job!!")
    @Column(length = 2000)
    @Size(max = 2000, message = "You have exceeded the size limit")
    private String responsibility;
    @NotNull(message = "Please enter the qualifications required for this job!!")
    @Column(length = 2000)
    @Size(max = 2000, message = "You have exceeded the size limit")
    private String qualification;
    @Column(length = 2000)
    @Size(max = 2000, message = "You have exceeded the size limit")
    private String prefered_Qualification;
    @NotNull(message = "Please enter the minimum salary!!")
    private double min_salary;
    @NotNull(message = "Please enter the maximim salary!!")
    private double max_salary;
    @Column(length = 2000)
    private String benefits;
    private String available="Yes";

    @OneToMany(mappedBy = "jobs")
    private List<Application> applications;

}
