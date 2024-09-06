package com.example.Job_Board.Controller;

import com.example.Job_Board.Dto.ApplicationDtoForApplication;
import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Application;
import com.example.Job_Board.Service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/application")
public class ApplicationController {
    public final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> save(@Valid @RequestBody Application application)
    {
        System.err.println(application);
        return ResponseEntity.ok(applicationService.save(application));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDtoForApplication>> allApplication ()
    {
        return ResponseEntity.ok(applicationService.allApplication());
    }

    @PostMapping("/find")
    public ResponseEntity<List<ApplicationDtoForApplication>> findApplications(@RequestBody Applicant applicant)
    {
        return ResponseEntity.ok(applicationService.findApplication(applicant));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(applicationService.deleteApplication(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable("id") Long id, @RequestBody Application application)
    {
        return ResponseEntity.ok(applicationService.changeStatus(id,application));
    }
}
