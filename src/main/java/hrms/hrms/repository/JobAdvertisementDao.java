package hrms.hrms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrms.entity.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByActiveTrue();

	List<JobAdvertisement> findByEmployer_IdAndActiveTrue(Integer employerId);

	List<JobAdvertisement> findAllByOrderByApplicationDeadlineAsc();

	@Query("select j from JobAdvertisement j where j.applicationDeadline = :deadline")
	List<JobAdvertisement> findByApplicationDeadline(LocalDate deadline);

}
