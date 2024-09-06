package com.example.Job_Board.Controller;

import com.example.Job_Board.Dto.ApplicantDto;
import com.example.Job_Board.Dto.ApplicantDtoForApplication;
import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Education;
import com.example.Job_Board.Entity.Experience;
import com.example.Job_Board.Service.ApplicantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/applicant")
public class ApplicantController {

    public final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/new")
    public ResponseEntity<Applicant> save(@Valid @RequestBody Applicant applicant)
    {
        return ResponseEntity.ok(applicantService.save(applicant));
    }

    @GetMapping
    public ResponseEntity<List<ApplicantDtoForApplication>> allApplicant()
    {
        return ResponseEntity.ok(applicantService.allApplicant());
    }

    @PostMapping("/login")
    public ResponseEntity<ApplicantDto> login(@RequestBody Applicant applicant)
    {
        return ResponseEntity.ok(applicantService.login(applicant));
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ApplicantDto> find(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(applicantService.find(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteApplicant (@PathVariable("id") Long id){
        return ResponseEntity.ok(applicantService.deleteApplicant(id));
    }

    @PatchMapping("edit/{id}")
    public ResponseEntity<String> editApplicant(@PathVariable("id") Long id, @RequestBody Applicant applicant)
    {
        return ResponseEntity.ok(applicantService.patchEditApplicant(id,applicant));
    }

    @PutMapping("education/{id}")
    public ResponseEntity<String> editEducation(@PathVariable("id") Long id, @RequestBody Education education){
        return ResponseEntity.ok(applicantService.editEducation(id,education));
    }

    @PutMapping("experience/{id}")
    public ResponseEntity<String> editExperience(@PathVariable("id") Long id, @RequestBody Experience experience){
        return ResponseEntity.ok(applicantService.editExperience(id,experience));
    }

    @GetMapping("find/edu/{id}")
    public ResponseEntity<Education> findEducation(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(applicantService.findEducation(id));
    }

    @GetMapping("find/exp/{id}")
    public ResponseEntity<Experience> findExperience(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(applicantService.findExperience(id));
    }

    @DeleteMapping("delete/edu/{id}")
    public ResponseEntity<String> deleteEducation(@PathVariable("id")Long id)
    {
        return ResponseEntity.ok(applicantService.deleteEducation(id));
    }

    @DeleteMapping("delete/exp/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable("id")Long id)
    {
        return ResponseEntity.ok(applicantService.deleteExperience(id));
    }
}
