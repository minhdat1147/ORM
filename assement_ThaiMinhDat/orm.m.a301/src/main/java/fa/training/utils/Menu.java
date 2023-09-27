package fa.training.utils;


import fa.training.dao.CandidateDao;
import fa.training.dao.EntityDao;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static EntityDao entityDao = new EntityDao<>();
	static CandidateDao candidateDao = new CandidateDao();
	
	// Exit function
	public static void exit() {
		for (int i = 0; i < 60; i++)
			System.out.println();
		System.out.println("Ban da thoat khoi chuong trinh. Cam on!");
	}

	// Main menu
	public static void MainMenu() {

		System.out.println("----//----//----//----//----//----//----//----//----");
		System.out.println("0. Add data into database");
		System.out.println("1. View all Candidate");
		System.out.println("2. View all Entry Test");
		System.out.println("3. View all Interview");
		System.out.println("4. Get Candidate by id");
		System.out.println("5. Get Entry Test Type by id");
		System.out.println("6. Get Interview Type by id");
		System.out.println("7. Find all of the candidate that has skill is 'Angluar’ and skill level is 2");
		System.out.println("8. Find all of the candidate that has foreign language is 'Japanese' and\r\n"
				+ "		 * skill is 'Python/ML");
		System.out.println("9. Find all of the candidate by skill and entry test result (that has skill\r\n"
				+ "		 * is ‘Java’ and pass entry test on '1-Oct-2020')");
		System.out.println("10. Find all of the candidate that pass interview on '15-Oct-2020'");
		System.out.println("11. Update remark is inactive for candidates who do not have either phone, email and cv");
		System.out.println("12. Exit");
		System.out.println("Nhan phim 12 neu muon thoat chuong trinh");
		System.out.println("------------------------------------------");
		System.out.println("Lua chon cua ban la: ");
		int choice0 = sc.nextInt();
		switch (choice0) {
		case 0:
			AddData.addData();
			MainMenu();
			break;
		case 1:
			entityDao.print(entityDao.getAll("Candidate"));
			MainMenu();
			break;
		case 2:
			entityDao.print(entityDao.getAll("EntryTest"));
			MainMenu();
			break;
		case 3:
			entityDao.print(entityDao.getAll("Interview"));
			MainMenu();
			break;
		case 4:
			System.err.println("Nhap Id: ");
			System.err.println(entityDao.getById(new Candidate(),sc.nextInt()));
			MainMenu();
			break;
		case 5:
			System.err.println("Nhap Id: ");
			System.err.println(entityDao.getById(new EntryTest(),sc.nextInt()));
			MainMenu();
			break;
		case 6:
			System.err.println("Nhap Id: ");
			System.err.println(entityDao.getById(new Interview(),sc.nextInt()));
			MainMenu();
			break;
		case 7:
			System.out.println("*****************************************************************************************");
			System.err.println("Find all of the candidate that has skill is 'Angluar’ and skill level is 2");
			List<Candidate> listCandidate1 =  candidateDao.getAllCandidateBySL("Angluar", 2);
			entityDao.print(listCandidate1);
			System.out.println("*****************************************************************************************");
			MainMenu();
			break;
		case 8:
			System.out.println("*****************************************************************************************");
			System.err.println("Find all of the candidate that has foreign language is 'Japanese' and skill is 'Python/ML");
			List<Candidate> listCandidate2 = candidateDao.getAllCandidateByLS("Japanese", "Python/ML");
			entityDao.print(listCandidate2);
			System.out.println("*****************************************************************************************");
			MainMenu();
			break;
		case 9:
			System.out.println("*****************************************************************************************");
			System.err.println("Find all of the candidate by skill and entry test result (that has skill is ‘Java’ "
					+ "and pass entry test on '1-Oct-2020')");
			List<Candidate> listCandidate3 = candidateDao.getAllCandidateBySRD("Java", "pass", LocalDate.of(2020, 10, 1));
			entityDao.print(listCandidate3);
			System.out.println("*****************************************************************************************");
			MainMenu();
			break;
		case 10:
			System.out.println("*****************************************************************************************");
			System.err.println("Find all of the candidate that pass interview on '15-Oct-2020'");
			List<Candidate> listCandidate4 = candidateDao.getAllCandidateByRDI("pass", LocalDate.of(2020, 10, 15));
			entityDao.print(listCandidate4);
			System.out.println("*****************************************************************************************");
			MainMenu();
			break;
		case 11:
			System.out.println("*****************************************************************************************");
			System.err.println("Update remark is inactive for candidates who do not have either phone, email and cv");
			candidateDao.updateRemark();
			System.out.println("*****************************************************************************************");
			MainMenu();
			break;
		case 12:
			exit();
			break;
		default:
			System.out.println("Ban da nhap sai. Xin moi nhap lai lua chon");
			MainMenu();
			break;
		}
	}

	// Main menu
	public static void SubMenu1() {
		System.out.println("----//----//----//----//----//----//----//----//----");
		System.out.println("Nhap lua chon chuong trinh:");
		System.out.println("Nhan phim 1 ...");
		System.out.println("Nhan phim 2 ...");
		System.out.println("Nhan phim 3 de quay lai menu truoc");
		System.out.println("Nhan phim 4 neu muon thoat chuong trinh");
		System.out.println("------------------------------------------");
		System.out.println("Lua chon cua ban la: ");
		int choice0 = sc.nextInt();
		switch (choice0) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			MainMenu();
			break;
		case 4:
			exit();
			break;
		default:
			System.out.println("Ban da nhap sai. Xin moi nhap lai lua chon");
			SubMenu1();
			break;
		}
	}

}
