package com.example.Job_Board.Service;

import com.example.Job_Board.Dto.ApplicantDto;
import com.example.Job_Board.Dto.ApplicantDtoForApplication;
import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Education;
import com.example.Job_Board.Entity.Experience;
import com.example.Job_Board.Model.convertToDto;
import com.example.Job_Board.Model.convertToDtoForApplication;
import com.example.Job_Board.Repository.ApplicantRepository;
import com.example.Job_Board.Repository.EducationRepository;
import com.example.Job_Board.Repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    public final ApplicantRepository applicantRepository;
    public final EducationRepository educationRepository;
    public final ExperienceRepository experienceRepository;

    public ApplicantService(ApplicantRepository applicantRepository, EducationRepository educationRepository, ExperienceRepository experienceRepository) {
        this.applicantRepository = applicantRepository;
        this.educationRepository = educationRepository;
        this.experienceRepository = experienceRepository;
    }

    public Applicant save(Applicant applicant) {
        Applicant applicant1=applicantRepository.save(applicant);
        if(applicant1!=null)
        {
            return applicant1;
        }
        return applicant;
    }

    public List<ApplicantDtoForApplication> allApplicant() {
        List<Applicant> applicants= applicantRepository.findAll();
        List<ApplicantDtoForApplication> applicantDtos=new ArrayList<>();
        convertToDtoForApplication dto = new convertToDtoForApplication();
        applicants.forEach(applicant -> {
            ApplicantDtoForApplication applicantDto=dto.convertToApplicantDto(applicant);
            applicantDtos.add(applicantDto);
        });
        return applicantDtos;
    }

    public ApplicantDto login(Applicant applicant) {
        Optional <Applicant> applicant1=applicantRepository.findByUsernameAndPassword(applicant.getUsername(),applicant.getPassword());
        convertToDto dto=new convertToDto();
        if (applicant1.isPresent())
        {
            return dto.convertApplicantToDto(applicant1.get());
        }
        return dto.convertApplicantToDto(applicant);
    }

    public ApplicantDto find(Long id) {
        Applicant applicant= applicantRepository.findById(id).get();
        convertToDto dto = new convertToDto();
        return dto.convertApplicantToDto(applicant);
    }

    public String deleteApplicant(Long id) {
        Optional<Applicant> applicant=applicantRepository.findById(id);
        if(applicant.isPresent())
        {
            applicantRepository.deleteById(id);
            return "Deleted Successfully";
        }
        return "Id not found";
    }

    public String patchEditApplicant(Long id, Applicant applicant) {
        Optional<Applicant> applicant1=applicantRepository.findById(id);

        if(applicant1.isPresent())
        {
            Applicant existingApplicant = applicant1.get();
            List<Education> educations = new ArrayList<>();
            List<Experience> experiences = new ArrayList<>();

            existingApplicant.setFullname(applicant.getFullname());
            existingApplicant.setUsername(applicant.getUsername());
            existingApplicant.setPassword(applicant.getPassword());
            existingApplicant.setEmail(applicant.getEmail());
            existingApplicant.setPhone(applicant.getPhone());
            existingApplicant.setSkills(applicant.getSkills());
            existingApplicant.setDesiredSalary(applicant.getDesiredSalary());
            existingApplicant.setAddress(applicant.getAddress());

            existingApplicant.getEducation().forEach(edu->{
                educations.add(edu);
            });
            applicant.getEducation().forEach(edu->{
                educations.add(edu);
            });
            existingApplicant.setEducation(educations);

            existingApplicant.getExperience().forEach(exp->{
                experiences.add(exp);
            });
            applicant.getExperience().forEach(exp->{
                experiences.add(exp);
            });
            existingApplicant.setExperience(experiences);

            applicantRepository.save(existingApplicant);

            return "Success";
        }

        return "The id is incorrect";
    }


    public String editEducation(Long id, Education education) {
        Optional<Education> education1=educationRepository.findById(id);
        if(education1.isPresent())
        {
            Education existingEducation=education1.get();
            existingEducation.setDegree(education.getDegree());
            existingEducation.setGpa(education.getGpa());
            existingEducation.setMajor(education.getMajor());
            existingEducation.setMinor(education.getMinor());
            existingEducation.setSchoolName(education.getSchoolName());
            educationRepository.save(existingEducation);
            return "Success";
        }
        return "Cannot find this education";
    }

    public String editExperience(Long id, Experience experience) {
        Optional<Experience> experience1=experienceRepository.findById(id);
        if(experience1.isPresent())
        {
            Experience existingExperience = experience1.get();
            existingExperience.setCompany_name(experience.getCompany_name());
            existingExperience.setJob_title(experience.getJob_title());
            existingExperience.setStarted(experience.getStarted());
            existingExperience.setEnded(experience.getEnded());
            existingExperience.setStill_there(experience.isStill_there());
            existingExperience.setResponsibilities(experience.getResponsibilities());
            experienceRepository.save(existingExperience);
            return "Success";
        }
        return "Cannot find this experience";
    }


    public Education findEducation(Long id) {
        Optional<Education> education = educationRepository.findById(id);
        if(education.isPresent())
        {
            return  education.get();
        }
        return null;
    }

    public Experience findExperience(Long id) {
        Optional<Experience> experience = experienceRepository.findById(id);
        if(experience.isPresent())
        {
            return experience.get();
        }
        return null;
    }

    public String deleteEducation(Long id) {
        Optional<Education> education = educationRepository.findById(id);
        if(education.isPresent())
        {
            educationRepository.deleteById(id);
            return "Success";
        }
        return "Error while deleting";
    }

    public String deleteExperience(Long id) {
        Optional<Experience> experience = experienceRepository.findById(id);
        if(experience.isPresent())
        {
            experienceRepository.deleteById(id);
            return "Success";
        }
        return "Error while deleting";
    }

    public List<String> allApplicantUsername() {
        List<Applicant> applicants = applicantRepository.findAll();
        List<String> usernames = new ArrayList<>();
        applicants.forEach(applicant -> {
            String s = applicant.getUsername();
            usernames.add(s);
        });
        return usernames;
    }


    /*public Long findApplicantForEducation(Long id) {
        //Long applicant= educationRepository.findApplicantById(id);
        return null;
    }*/
}
