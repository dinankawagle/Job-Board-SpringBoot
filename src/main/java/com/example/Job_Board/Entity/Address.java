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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;
    @NotNull(message = "Please enter your street!!")
    private String street;
    @NotNull(message = "Please enter your city!!")
    private String city;
    private String state;
    @NotNull(message = "Please enter you country!!")
    private String country;
    private String zip_code;
}
