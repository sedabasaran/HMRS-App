package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CityService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.ErrorResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.dto.CityDto;
import hrms.hrms.dto.request.CreateCityRequest;
import hrms.hrms.entity.City;
import hrms.hrms.repository.CityDao;

@Service
public class CityManager implements CityService {

	private final CityDao cityDao;

	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public Result add(CreateCityRequest request) {
		if (cityDao.findByCityName(request.getCityName()).isPresent()) {
			return new ErrorResult("City already exists.");
		}
		City city = new City();
		city.setCityName(request.getCityName());
		cityDao.save(city);
		return new SuccessResult("City created.");
	}

	@Override
	public DataResult<List<CityDto>> getAll() {
		var list = cityDao.findAll().stream().map(c -> new CityDto(c.getId(), c.getCityName())).toList();
		return new SuccessDataResult<>(list, "Cities listed.");
	}

}
