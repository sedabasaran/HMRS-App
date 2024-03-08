package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobPosition;

public interface JobPositonDao extends JpaRepository<JobPosition, Integer> {
	JobPosition findByTitle(String title);


}
