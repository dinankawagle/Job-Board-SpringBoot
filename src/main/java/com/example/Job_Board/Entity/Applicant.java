package com.example.Job_Board.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Please enter your name!!")
    private String fullname;
    @NotNull(message = "Please enter an username!!")
    private String username;
    @NotNull(message = "Please enter a password!!")
    @Size(min = 8, max = 24, message = "Password must be between 8 and 24 characters")
    private String password;
    @NotNull(message = "Please enter your email!!")
    @Email(message = "Please enter a valid email!!")
    private String email;
    @NotNull(message = "Please enter your phone number!!")
    @Size(min = 10,max = 10,message = "Please enter a valid 10 digit phone number only")
    private String phone;
    @Column(length = 1000)
    private String skills;
    @NotNull(message = "Please enter your desired salary")
    private double desiredSalary;

    @NotNull(message = "Please enter your address!!")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant",referencedColumnName = "id")
    private List<Education> education;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant",referencedColumnName = "id")
    private List<Experience> experience;

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;
}
