package com.example.Job_Board.Repository;

import com.example.Job_Board.Entity.Applicant;
import com.example.Job_Board.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    @Query(value = "select applicant_id from education where education_id=:id",nativeQuery = true)
    List<Application> allApplications(Long id);

    List<Application> findAllApplicationByApplicant(Applicant applicant);

    @Query(value = "select*from application order by id desc",nativeQuery = true)
    List<Application> findAllApplicanDesc();
//select*from application order by id desc

    /*@Query(value = "select*from application where applicant_id=:id",nativeQuery = true)
    List<Application> allApplications(Long id);*/
}
