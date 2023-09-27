package trainning.hibernate.dao;

import java.util.List;

public interface EntityDao<T> {
    T getById(T object, int id);
    List<T> getAll (String entityClassName);
    void delete(T object);
    void showInformation(List<T> objects);
}
