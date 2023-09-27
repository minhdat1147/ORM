package fa.training.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import fa.training.entities.Candidate;
import fa.training.entities.Interview;
import fa.training.utils.HibernateUtils;
import org.hibernate.*;

public class CandidateDao extends EntityDao<Object> {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	/**
	 * a) Find all of the candidate by Skill and Level (use HQL)
	 *
	 * @return
	 */
	public List<Candidate> getAllCandidateBySL(String strSkill, int intLevel) {
		Session session = sessionFactory.openSession();

		String hql = "FROM Candidate AS C WHERE C.skill = :strSkill AND C.level = :intLevel";

		try {
			Query query = session.createQuery(hql);

			query.setParameter("strSkill", strSkill);
			query.setParameter("intLevel", intLevel);

			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * b) Find all of the candidate by Foreign Language and Skills (use HQL)
	 *
	 * @return
	 */
	public List<Candidate> getAllCandidateByLS(String strForeignLanguage, String strSkill) {
		Session session = sessionFactory.openSession();

		String hql = "FROM Candidate AS C WHERE C.foreignLanguage = :strForeignLanguage AND C.skill = :strSkill";

		try {
			Query query = session.createQuery(hql);

			query.setParameter("strForeignLanguage", strForeignLanguage);
			query.setParameter("strSkill", strSkill);

			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * c) Find all of the candidate by skill and entry test result (use HQL)
	 *
	 * @return
	 */
	public List<Candidate> getAllCandidateBySRD(String strSkill, String strResult, LocalDate ldDate) {
		Session session = sessionFactory.openSession();

		String hql = "FROM Candidate AS C JOIN C.setEntryTest AS E "
				+ "WHERE C.skill = :strSkill AND E.result = :strResult AND E.date = :ldDate";

//		String hql = "FROM Candidate AS C JOIN C.entryTest AS E "
//				+ "WHERE C.skill = :strSkill AND E.result = :strResult AND E.date = :ldDate";

		try {
			Query query = session.createQuery(hql);

			query.setParameter("strSkill", strSkill);
			query.setParameter("strResult", strResult);
			query.setParameter("ldDate", ldDate);

			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * d) Find all of the candidate by Result and Date of Interview. (use Criteria)
	 *
	 * @return
	 */
	public List<Candidate> getAllCandidateByRDI(String strInterviewResult, LocalDate ldDate) {
		Session session = sessionFactory.openSession();

		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Candidate> criteriaQuery = criteriaBuilder.createQuery(Candidate.class);

			// Select From
			Root<Candidate> candidateRoot = criteriaQuery.from(Candidate.class);

			// Join
			ListJoin<Candidate, Interview> listJoin = candidateRoot.joinList("setInterview", JoinType.INNER);

			// Expressions
			Predicate equalDate = criteriaBuilder.equal(listJoin.get("date"), ldDate);
			Predicate likeResult = criteriaBuilder.like(listJoin.get("interviewResult"), strInterviewResult);
			Predicate andDateResult = criteriaBuilder.and(equalDate, likeResult);

			// Create select using expressions
			criteriaQuery.select(candidateRoot).where(andDateResult);

			// Prepare the query for execution
			Query<Candidate> queryCandidate = session.createQuery(criteriaQuery);

			// Excute the query
			List<Candidate> listCandidate = queryCandidate.getResultList();

			return listCandidate;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	/**
	 * e) Update remark is inactive for candidates who do not have either phone, email and cv. (use Criteria)
	 *
	 * @return
	 */
	public boolean updateRemark() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaUpdate<Candidate> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Candidate.class);

			// Select From
			Root<Candidate> candidateRoot = criteriaUpdate.from(Candidate.class);

			//Expressions
			Predicate isNullPhone = criteriaBuilder.isNull(candidateRoot.get("phone"));
			Predicate isNullEmail = criteriaBuilder.isNull(candidateRoot.get("email"));
			Predicate isNullCv = criteriaBuilder.isNull(candidateRoot.get("cv"));
			Predicate allPredicate = criteriaBuilder.or(isNullPhone, isNullEmail,isNullCv);

			//Create Update
			CriteriaUpdate<Candidate> setCandidateCriteriaUpdate = criteriaUpdate.set("remark", "inactive");

			//Where expression
			CriteriaUpdate<Candidate> whereCandidateCriteriaUpdate = setCandidateCriteriaUpdate.where(allPredicate);

			//Prepare the query for execution
			Query<Candidate> queryCandidate = session.createQuery(whereCandidateCriteriaUpdate);

			int listCandidate = queryCandidate.executeUpdate();

			// Commit to database
			if (listCandidate != 0) {
				System.err.println(listCandidate + " rows affected");
				transaction.commit();
				return true;
			} else {
				System.err.println("Update failed !");
				return false;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

//	/**
//	 * phan trang hibernate tuong tu select top xxx phan trang de chia ket qua cau
//	 * query ra thanh tung trang, va truy cap trang minh muon
//	 * 
//	 * @param pageNumber : so thu tu cua trang ma minh muon truy cap
//	 * @param pageSize   : so luong row cua moi~ trang
//	 * @return
//	 */
//	public List<Candidate> searchPagination(int pageNumber, int pageSize) {
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Candidate> criteriaQuery = criteriaBuilder.createQuery(Candidate.class);
//		Root<Candidate> root = criteriaQuery.from(Candidate.class);
//		criteriaQuery.select(root);
//		Query<Candidate> query = session.createQuery(criteriaQuery);
//		query.setFirstResult((pageNumber - 1) * pageSize);
//		query.setMaxResults(pageSize);
//		List<Candidate> listOfUser = query.getResultList();
//		session.close();
//		return listOfUser;

}
