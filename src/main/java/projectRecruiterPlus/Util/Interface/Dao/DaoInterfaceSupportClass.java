package projectRecruiterPlus.Util.Interface.Dao;

import java.util.List;

public interface DaoInterfaceSupportClass<T> {

	boolean save(T team);

	T getById(int id);

	T getByName(String name);

	List<T> getAll();

	boolean delete(T team);

}
