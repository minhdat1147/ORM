package fa.training.utils;

import fa.training.dao.EntityDao;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;

import java.time.LocalDate;

public class AddData {
	public static void addData() {
		EntityDao<Object> entityDao = new EntityDao<>();
		ValidatorHibernate validatorHibernate = new ValidatorHibernate();
		
		Candidate candidate1 = new Candidate("nguyen van A", LocalDate.of(1999, 1, 1), 0, LocalDate.of(2019, 1, 1),
				"0905000001", "nva@gmail.com", "Java", "English", 5, "cv-1", 1, "remark-1");

		Candidate candidate2 = new Candidate("nguyen van B", LocalDate.of(1999, 1, 2), 0, LocalDate.of(2019, 1, 2),
				"0905000002", "nvb@gmail.com", "Angluar", "English", 2, null, 1, "remark-2");

		Candidate candidate3 = new Candidate("nguyen van C", LocalDate.of(1999, 1, 3), 0, LocalDate.of(2019, 1, 3),
				"0905000003", "nvc@gmail.com", "Python/ML", "Japanese", 1, "cv-3", 1, "remark-3");

		Candidate candidate4 = new Candidate("nguyen van D", LocalDate.of(1999, 1, 4), 0, LocalDate.of(2019, 1, 4),
				"0905000004", "nvd@gmail.com", "Python/ML", "Japanese", 1, null, 1, "remark-4");

		if (validatorHibernate.isValidInput(candidate1)) {
			entityDao.save(candidate1);
		}

		if (validatorHibernate.isValidInput(candidate2)) {
			entityDao.save(candidate2);
		}

		if (validatorHibernate.isValidInput(candidate3)) {
			entityDao.save(candidate3);
		}

		if (validatorHibernate.isValidInput(candidate4)) {
			entityDao.save(candidate4);
		}

		EntryTest entryTest1 = new EntryTest("time 1", LocalDate.of(2020, 10, 1), "language valuator 1", 9,
				"technical valuator 1", 9, "pass", "remark 1", "entryTestSkill 1", candidate1);

		EntryTest entryTest2 = new EntryTest("time 2", LocalDate.of(2020, 1, 2), "language valuator 2", 8,
				"technical valuator 2", 8, "pass", "remark 2", "entryTestSkill 2", candidate2);

		EntryTest entryTest3 = new EntryTest("time 3", LocalDate.of(2020, 1, 3), "language valuator 3", 7,
				"technical valuator 3", 7, "pass", "remark 3", "entryTestSkill 3", candidate2);

		EntryTest entryTest4 = new EntryTest("time 4", LocalDate.of(2020, 1, 4), "language valuator 4", 6,
				"technical valuator 4", 6, "fail", "remark 4", "entryTestSkill 4", candidate3);

		EntryTest entryTest5 = new EntryTest("time 5", LocalDate.of(2020, 1, 5), "language valuator 1", 5,
				"technical valuator 5", 5, "fail", "remark 51", "entryTestSkill 5", candidate4);

		EntryTest entryTest6 = new EntryTest("time 6", LocalDate.of(2020, 1, 6), "language valuator 6", 4,
				"technical valuator 6", 4, "fail", "remark 6", "entryTestSkill 6", candidate4);

		if (validatorHibernate.isValidInput(entryTest1)) {
			entityDao.save(entryTest1);
		}

		if (validatorHibernate.isValidInput(entryTest2)) {
			entityDao.save(entryTest2);
		}

		if (validatorHibernate.isValidInput(entryTest3)) {
			entityDao.save(entryTest3);
		}

		if (validatorHibernate.isValidInput(entryTest4)) {
			entityDao.save(entryTest4);
		}

		if (validatorHibernate.isValidInput(entryTest5)) {
			entityDao.save(entryTest5);
		}

		if (validatorHibernate.isValidInput(entryTest6)) {
			entityDao.save(entryTest6);
		}

		Interview innterview1 = new Interview("time-1", LocalDate.of(2020, 2, 1), "interview-1", "comment-1",
				"pass", "remark-1", candidate1);

		Interview innterview2 = new Interview("time-2", LocalDate.of(2020, 10, 15), "interview-2", "comment-2",
				"pass", "remark-2", candidate2);

		Interview innterview3 = new Interview("time-3", LocalDate.of(2020, 10, 15), "interview-3", "comment-3",
				"pass", "remark-3", candidate2);

		Interview innterview4 = new Interview("time-4", LocalDate.of(2020, 10, 15), "interview-4", "comment-4",
				"fail", "remark-4", candidate3);

		Interview innterview5 = new Interview("time-5", LocalDate.of(2020, 10, 15), "interview-5", "comment-5",
				"fail", "remark-5", candidate4);

		Interview innterview6 = new Interview("time-6", LocalDate.of(2020, 2, 6), "interview-6", "comment-6",
				"fail", "remark-6", candidate4);

		if (validatorHibernate.isValidInput(innterview1)) {
			entityDao.save(innterview1);
		}

		if (validatorHibernate.isValidInput(innterview2)) {
			entityDao.save(innterview2);
		}

		if (validatorHibernate.isValidInput(innterview3)) {
			entityDao.save(innterview3);
		}

		if (validatorHibernate.isValidInput(innterview3)) {
			entityDao.save(innterview3);
		}

		if (validatorHibernate.isValidInput(innterview4)) {
			entityDao.save(innterview4);
		}

		if (validatorHibernate.isValidInput(innterview4)) {
			entityDao.save(innterview4);
		}
		System.err.println("Insert data susscessfully !");
		

	}
}
