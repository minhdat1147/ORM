package training.hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import training.hibernate.dao.EmployeeDaoImpl;
import training.hibernate.model.Employee;
import training.hibernate.utils.Validator;

import java.util.Scanner;


public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        while (true){
            showMenu();
            System.out.println("Choice option");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("======================ADD EMPLOYEE=====================");
                    System.out.println("Enter the number employee need to add");
                    boolean valid = false;
                    String n = null;
                    while (valid == false){
                        System.out.println("Enter number more than 0 and have 2 number");
                        n = scanner.next();
                        try{
                            valid = Validator.isIntegerInput(n);
                            if(valid == false){
                                System.err.println("Enter again!!!");
                            }
                        }catch (Exception e){
                            valid = false;
                        }
                    }
                    int lengh = Integer.parseInt(n);
                    scanner.nextLine();
                    for (int i =0 ; i<lengh; i++){
                        System.out.println("Enter Employee element "+(i+1));
                        System.out.println("Enter first name:");
                        employee.setFirstName(scanner.nextLine());
                        System.out.println("Enter last name:");
                        employee.setLastName(scanner.nextLine());
                        employeeDao.addEmployee(employee.getFirstName(), employee.getLastName());
                    }
                    break;
                case 2:
                    System.out.println("=======================SHOW EMPLOYEE LIST==================");
                    employeeDao.listEmployees();
                    break;
                case 0:
                    System.out.println("Exit!!!");
                    System.exit(choice);
                    break;
                default:
                    break;
            }
        }
    }
    public static void showMenu(){
        System.out.println("1. Add Employees");
        System.out.println("2. Show list employee");
        System.out.println("0. exit");
    }
}
