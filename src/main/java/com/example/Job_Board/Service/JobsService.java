package com.example.Job_Board.Service;

import com.example.Job_Board.Dto.JobsDto;
import com.example.Job_Board.Dto.JobsDtoForApplication;
import com.example.Job_Board.Entity.Jobs;
import com.example.Job_Board.Model.convertToDto;
import com.example.Job_Board.Model.convertToDtoForApplication;
import com.example.Job_Board.Repository.JobsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    public final JobsRepository jobsRepository;

    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public Jobs save(Jobs jobs) {
        Jobs jobs1 = jobsRepository.save(jobs);
        if(jobs1!=null)
        {
            return jobs1;
        }
        return jobs;
    }

    public List<JobsDtoForApplication> allJobs() {
        List<Jobs> jobs= jobsRepository.findAll();
        List<JobsDtoForApplication> jobsDtos=new ArrayList<>();
        convertToDtoForApplication dto = new convertToDtoForApplication();
        jobs.forEach(job ->{
            JobsDtoForApplication jobDto = dto.convertToJobsDto(job);
            jobsDtos.add(jobDto);
        });
        return jobsDtos;
    }

    public JobsDto findJob(Long id) {
        Optional<Jobs> jobs = jobsRepository.findById(id);
        convertToDto dto = new convertToDto();
        JobsDto jobsDto = new JobsDto();
        if(jobs.isPresent())
        {
            return dto.convertJobsToDto(jobs.get());
        }
        return jobsDto;
    }

    public String deleteJob(Long id) {
        Optional<Jobs> jobs=jobsRepository.findById(id);
        if(jobs.isPresent())
        {
            jobsRepository.deleteById(id);
            return "Deleted Successfully";
        }
        return "This id does not exist";
    }

    public String putEditJob(Long id, Jobs jobs) {
        Optional<Jobs> jobs1=jobsRepository.findById(id);
        if(jobs1.isPresent())
        {
            /* private String title;
    private String type;
    private String level;
    private String city;
    private String country;
    private LocalDate posted;
    private LocalDate updated;
    private String description;
    private String responsibility;
    private String qualification;
    private String prefered_Qualification;
    private double min_salary;
    private double max_salary;
    private String benefits;*/

            Jobs existingJob = jobs1.get();
            existingJob.setTitle(jobs.getTitle());
            existingJob.setType(jobs.getType());
            existingJob.setLevel(jobs.getLevel());
            existingJob.setCity(jobs.getCity());
            existingJob.setCountry(jobs.getCountry());
            existingJob.setUpdated(jobs.getUpdated());
            existingJob.setDescription(jobs.getDescription());
            existingJob.setResponsibility(jobs.getResponsibility());
            existingJob.setQualification(jobs.getQualification());
            existingJob.setPrefered_Qualification(jobs.getPrefered_Qualification());
            existingJob.setMin_salary(jobs.getMin_salary());
            existingJob.setMax_salary(jobs.getMax_salary());
            existingJob.setBenefits(jobs.getBenefits());

            jobsRepository.save(existingJob);
            return "This job is updated";
        }
        return "This id does not exist";
    }

    public String editAvailableJob(Long id, String s) {
        Optional<Jobs> jobs1=jobsRepository.findById(id);
        if(jobs1.isPresent())
        {
            Jobs existingJob = jobs1.get();
            if(s!=null)
            {
                existingJob.setAvailable(s);
            }
            jobsRepository.save(existingJob);
            return "Success";
        }
        return "This id does not exist";
    }
}
