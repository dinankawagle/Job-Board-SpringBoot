package com.example.Job_Board.Controller;

import com.example.Job_Board.Dto.JobsDto;
import com.example.Job_Board.Dto.JobsDtoForApplication;
import com.example.Job_Board.Entity.Jobs;
import com.example.Job_Board.Service.JobsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/jobs")
public class JobsController {

    public final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @PostMapping("/new")
    public ResponseEntity<Jobs> save(@Valid @RequestBody Jobs jobs)
    {
        return ResponseEntity.ok(jobsService.save(jobs));
    }

    @GetMapping
    public ResponseEntity<List<JobsDtoForApplication>> allJobs()
    {
        return ResponseEntity.ok(jobsService.allJobs());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JobsDto> findJob (@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(jobsService.findJob(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteJob (@PathVariable("id") Long id){
        return ResponseEntity.ok(jobsService.deleteJob(id));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<String> editJob(@PathVariable("id") Long id, @RequestBody Jobs jobs)
    {
        return ResponseEntity.ok(jobsService.putEditJob(id,jobs));
    }

    @PatchMapping("available/{id}/{s}")
    public ResponseEntity<String> editAvailable(@PathVariable("id") Long id, @PathVariable("s") String s)
    {
        return ResponseEntity.ok(jobsService.editAvailableJob(id,s));
    }

}
