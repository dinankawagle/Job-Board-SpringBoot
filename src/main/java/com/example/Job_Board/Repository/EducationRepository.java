package com.example.Job_Board.Repository;

import com.example.Job_Board.Entity.Application;
import com.example.Job_Board.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {
    //Long findApplicantById(Long id);
    //Long findApplicant_idById(Long id);

    //@Query(value = "select applicant_id from experience where experience_id=:id",nativeQuery = true)
    //Long applicantId(Long id);
    //select applicant_id from experience where experience_id=2;
}
