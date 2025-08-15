package hrms.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entity.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    Optional<JobSeeker> findByEmail(String email);
    Optional<JobSeeker> findByNationalId(String nationalId);

}
