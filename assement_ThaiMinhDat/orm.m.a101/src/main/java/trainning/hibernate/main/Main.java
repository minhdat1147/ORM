package trainning.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import trainning.hibernate.utils.SeatUtils;

import java.util.Scanner;

public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();

        }catch (Throwable e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            showMenuMain();
            System.out.println("Choice option");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    SeatUtils seatUtils = new SeatUtils();
                    seatUtils.handleSeatFunction();
                    break;
            }
        }


    }
    public static void showMenuMain(){
        System.out.println("1. Choice Handle Seat");
        System.out.println("2. Choice handle Room");
        System.out.println("3. Choice handle Room detail");
        System.out.println("4. Exit!!");
    }
}
