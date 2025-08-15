package hrms.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entity.City;

public interface CityDao extends JpaRepository<City,Integer> {
    Optional<City> findByCityName(String cityName);


}
