package com.example.Job_Board.Service;

import com.example.Job_Board.Dto.ApplicationDtoForApplication;
import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Application;
import com.example.Job_Board.Entity.Jobs;
import com.example.Job_Board.Repository.ApplicantRepository;
import com.example.Job_Board.Repository.ApplicationRepository;
import com.example.Job_Board.Repository.JobsRepository;
import org.springframework.stereotype.Service;
import com.example.Job_Board.Model.convertToDtoForApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    public final ApplicationRepository applicationRepository;
    public final ApplicantRepository applicantRepository;
    public final JobsRepository jobsRepository;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository, JobsRepository jobsRepository) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
        this.jobsRepository = jobsRepository;
    }

    public String save(Application application) {
        Optional<Applicant> applicant=applicantRepository.findById(application.getApplicant().getId());
        Optional<Jobs> jobs=jobsRepository.findById(application.getJobs().getId());
        if (!((applicant.isPresent())||(jobs.isPresent())))
        {
            return "Invalid Applicant ID or Job ID";
        }
        application.setApplicant(applicant.get());
        application.setJobs(jobs.get());
        applicationRepository.save(application);
        return "Save Successful";
    }


    public List<ApplicationDtoForApplication> allApplication() {
        List<Application> applications=applicationRepository.findAll();
        List<ApplicationDtoForApplication> applicationDtos=new ArrayList<>();
        convertToDtoForApplication dto = new convertToDtoForApplication();
        applications.forEach(application -> {
            ApplicationDtoForApplication applicationDto = dto.convertToApplicationDto(application);
            applicationDtos.add(applicationDto);
        });
        return applicationDtos;
    }

    public List<ApplicationDtoForApplication> findApplication(Applicant applicant) {
        List<Application> applications = applicationRepository.findAllApplicationByApplicant(applicant);
        convertToDtoForApplication dto = new convertToDtoForApplication();
        List<ApplicationDtoForApplication> applicationList = new ArrayList<>();
        applications.forEach(application -> {
            ApplicationDtoForApplication application1 = dto.convertToApplicationDto(application);
            applicationList.add(application1);
        });
        return applicationList;
    }

    public String deleteApplication(Long id) {
        Optional<Application> application = applicationRepository.findById(id);
        if(application.isPresent())
        {
            applicationRepository.deleteById(id);
            return "Application deleted";
        }
        return "ID not found";
    }

    public String changeStatus(Long id, Application application) {
        Optional<Application> app = applicationRepository.findById(id);
        if(app.isPresent())
        {
            Application existingApplication = app.get();
            if(application.getStatus()!=null)
            {
                existingApplication.setStatus(application.getStatus());
            }
            applicationRepository.save(existingApplication);
            return "Success";
        }
        return "ID not found";
    }
}
