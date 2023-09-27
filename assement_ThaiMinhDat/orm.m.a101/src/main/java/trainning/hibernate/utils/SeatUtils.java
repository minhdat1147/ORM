package trainning.hibernate.utils;

import trainning.hibernate.dao.EntityDao;
import trainning.hibernate.dao.EntityDaoImpl;
import trainning.hibernate.dao.SeatDao;
import trainning.hibernate.dao.SeatDaoImpl;
import trainning.hibernate.entities.Seat;

import java.util.Scanner;

public class SeatUtils extends ShowUtils{
    public int handleSeatFunction(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            EntityDao entityDao = new EntityDaoImpl();
            SeatDao seatDao = new SeatDaoImpl();
            showMenuFunction();
            System.out.println("Choice option");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("==========Add Seat==============");
                    Seat seat = new Seat();
                    System.out.println("Enter the number set need to add");
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
                        System.out.println("Enter Seat element "+(i+1));

                            System.out.println("Choice Room Id");
                            System.out.println("1. Room 1");
                            System.out.println("2. Room 2");
                            System.out.println("3. Room 3");
                            System.out.println("4. Room 4");
                            System.out.println("5. Room 5");
                            int choiceRoomId = Integer.parseInt(scanner.nextLine());
                            switch (choiceRoomId){
                                case 1:
                                    seat.setRoom(1);
                                    break;
                                case 2:
                                    seat.setRoom(2);
                                    break;
                                case 3:
                                    seat.setRoom(3);
                                    break;
                                case 4:
                                    seat.setRoom(4);
                                    break;
                                case 5:
                                    seat.setRoom(5);
                                    break;
                                default:
                                    System.out.println("Enter not valid. Enter gain!");
                                    break;
                            }
                            scanner.nextLine();
                        System.out.println("Enter seat column:");
                        seat.setSeatColumn(scanner.nextLine());
                        System.out.println("Enter seat row:");
                        seat.setSeatRow(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Enter seat status");
                        seat.setSeatStatus(scanner.nextLine());
                        System.out.println("Enter seat Type");
                        seat.setSeatType(scanner.nextLine());

                        seatDao.addSeat(seat.getRoom(), seat.getSeatColumn(), seat.getSeatRow(), seat.getSeatStatus(), seat.getSeatType());
                    }
                    break;
                case 2:
                    System.out.println("Enter seat id");
                    entityDao.getById(new Seat(), scanner.nextInt());
                    break;
                case 3:
                    entityDao.delete(new Seat());
                    break;
                case 4:
                    System.out.println("Enter seat id need update");
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Exit!!!");
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Choice is not valid");
                    break;
            }
        }
    }
}
