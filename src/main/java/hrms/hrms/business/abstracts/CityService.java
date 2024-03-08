package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.entities.concretes.City;

public interface CityService {
	Result add(City city);
	DataResult<List<City>> getAll();

}
