package hrms.hrms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entity.JobApplication;

public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {


    Optional<JobApplication> findByJobAdvertisement_IdAndJobSeeker_Id(Integer jobAdvertisementId, Integer jobSeekerId);

    List<JobApplication> findByJobAdvertisement_Id(Integer jobAdvertisementId);

    List<JobApplication> findByJobSeeker_Id(Integer jobSeekerId);
}