package com.example.Job_Board.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private LocalDate submitted=LocalDate.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobs", referencedColumnName = "id")
    private Jobs jobs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant", referencedColumnName = "id")
    private Applicant applicant;
}
