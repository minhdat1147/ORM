package fa.training.dao;

import fa.training.entities.Jobs;

public interface JobDao {

	boolean save(Jobs job) throws Exception;

}
