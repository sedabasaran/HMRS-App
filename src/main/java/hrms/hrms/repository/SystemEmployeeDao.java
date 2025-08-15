package hrms.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entity.SystemEmployee;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {

}
