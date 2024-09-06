package com.example.Job_Board.Model;

import com.example.Job_Board.Dto.ApplicantDtoForApplication;
import com.example.Job_Board.Dto.ApplicationDtoForApplication;
import com.example.Job_Board.Dto.JobsDtoForApplication;
import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Application;
import com.example.Job_Board.Entity.Jobs;
import org.springframework.beans.BeanUtils;

public class convertToDtoForApplication {
    public ApplicantDtoForApplication convertToApplicantDto(Applicant applicant)
    {
        ApplicantDtoForApplication dto = new ApplicantDtoForApplication();
        BeanUtils.copyProperties(applicant,dto);
        return dto;
    }

    public JobsDtoForApplication convertToJobsDto (Jobs jobs)
    {
        JobsDtoForApplication dto = new JobsDtoForApplication();
        BeanUtils.copyProperties(jobs,dto);
        return dto;
    }

    public ApplicationDtoForApplication convertToApplicationDto (Application application)
    {
        ApplicationDtoForApplication dto=new ApplicationDtoForApplication();
        dto.setId(application.getId());
        dto.setStatus(application.getStatus());
        dto.setSubmitted(application.getSubmitted());
        dto.setApplicant(convertToApplicantDto(application.getApplicant()));
        dto.setJobs(convertToJobsDto(application.getJobs()));
        return dto;
    }

}
