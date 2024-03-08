package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrms.entities.concretes.JobAdvertisement;
import java.sql.Date;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	//List<JobAdvertisement> getByApplicationDeadline(Date applicationDeadline);
    @Query("From JobAdvertisement where applicationDeadline=:applicationDeadline")
	List<JobAdvertisement> getByApplicationDeadline();
	
	
}
