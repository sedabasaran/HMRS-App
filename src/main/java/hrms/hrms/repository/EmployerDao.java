package hrms.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entity.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Optional<Employer> findByEmail(String email);

	

}
