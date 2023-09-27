package training.hibernate.dao;

public interface EmployeeDao {
    Integer addEmployee(String firstName, String lastName);
    void listEmployees();
}
