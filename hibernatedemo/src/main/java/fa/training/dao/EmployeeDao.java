package fa.training.dao;

import fa.training.entities.Employees;

public interface EmployeeDao {

	boolean save(Employees employee) throws Exception;

}
