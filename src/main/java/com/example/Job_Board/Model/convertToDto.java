package com.example.Job_Board.Model;

import com.example.Job_Board.Dto.ApplicantDto;
import com.example.Job_Board.Dto.ApplicationDtoForApplicant;
import com.example.Job_Board.Dto.ApplicationDtoForJobs;
import com.example.Job_Board.Dto.JobsDto;
import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Application;
import com.example.Job_Board.Entity.Jobs;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class convertToDto {
    public ApplicationDtoForApplicant convertApplicantionToDtoForApplicant (Application applicantion)
    {
        ApplicationDtoForApplicant dto=new ApplicationDtoForApplicant();
        convertToDtoForApplication dtoForApplication = new convertToDtoForApplication();
        dto.setId(applicantion.getId());
        dto.setSubmitted(applicantion.getSubmitted());
        dto.setStatus(applicantion.getStatus());
        dto.setJobs(dtoForApplication.convertToJobsDto(applicantion.getJobs()));
        return dto;
    }

    public ApplicationDtoForJobs convertApplicantionToDtoForJobs (Application applicantion)
    {
        ApplicationDtoForJobs dto=new ApplicationDtoForJobs();
        convertToDtoForApplication dtoForApplication = new convertToDtoForApplication();
        dto.setId(applicantion.getId());
        dto.setSubmitted(applicantion.getSubmitted());
        dto.setStatus(applicantion.getStatus());
        dto.setApplicant(dtoForApplication.convertToApplicantDto(applicantion.getApplicant()));
        return dto;
    }

    public ApplicantDto convertApplicantToDto (Applicant applicant)
    {
        ApplicantDto dto=new ApplicantDto();
        BeanUtils.copyProperties(applicant,dto);
        List<Application> applications = applicant.getApplications();
        List<ApplicationDtoForApplicant> applicationDtos=new ArrayList<>();
        if (applications!=null) {
            applications.forEach(application -> {
                ApplicationDtoForApplicant applicationDto = new ApplicationDtoForApplicant();
                applicationDto = convertApplicantionToDtoForApplicant(application);
                applicationDtos.add(applicationDto);
            });
        }
        dto.setApplications(applicationDtos);
        return dto;
    }

    public JobsDto convertJobsToDto (Jobs jobs)
    {
        JobsDto dto=new JobsDto();
        BeanUtils.copyProperties(jobs,dto);
        List<Application> applications = jobs.getApplications();
        List<ApplicationDtoForJobs> applicationDtos=new ArrayList<>();
        if (applications!=null) {
            applications.forEach(application -> {
                ApplicationDtoForJobs applicationDto = new ApplicationDtoForJobs();
                applicationDto = convertApplicantionToDtoForJobs(application);
                applicationDtos.add(applicationDto);
            });
        }
        dto.setApplications(applicationDtos);
        return dto;
    }
}
