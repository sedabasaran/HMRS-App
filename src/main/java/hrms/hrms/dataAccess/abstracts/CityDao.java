package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer> {


}
