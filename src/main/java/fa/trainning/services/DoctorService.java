//package fa.trainning.services;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Set;
//
//import javax.management.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.JoinType;
//import javax.persistence.criteria.Root;
//import org.hibernate.Transaction;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
//import org.hibernate.Session;
//
//import fa.trainning.dao.DoctorDao;
//import fa.trainning.entities.Doctor;
//import fa.trainning.utils.HibernateUtil;
//
//
//public class DoctorService {
//	private static DoctorDao DoctorDao = new DoctorDao();
//	
//	public static void insertDoctorTest(Doctor doctor) {
////		DoctorDao DoctorDao = new DoctorDaoImpl();	
//		DoctorDao.insertDoctor(doctor);
//	}
//	
//	public static void showAllDoctorTest() {
//		List<Doctor> DoctorList = DoctorDao.getAllDoctor();
//		
//		for (Doctor Doctor : DoctorList) {
//			System.out.println(Doctor.toString());
//		}		
//	}
//	
//	
//	public static void deleteOneDoctorById(int id) {
//		DoctorDao.deleteDoctorByID(id);
//	}
//	
//	public static Doctor getOneDoctorById(int id) {
//		return DoctorDao.getDoctorByID(id);
//	}
//	
////	public static boolean CheckDoctorValidate(Doctor obj) {
////		boolean isCheck = true;
////		// Create ValidatorFactory which returns validator
////		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
////		// It validates bean instances
////		Validator validator = factory.getValidator();
////
////		// Validate bean
////		Set<ConstraintViolation<Doctor>> constraintViolations = validator.validate(obj);
////		// Show errors
////		if (constraintViolations.size() > 0) {
////			for (ConstraintViolation<Doctor> violation : constraintViolations) {
////				System.out.println(violation.getMessage());
////				isCheck = false;
////			}
////		} else {
////			System.out.println("Valid Object");
////		}
////		return isCheck;
////	}
////	
////	
////	public static List<Doctor> findDoctors(String skill, int skillLevel) {
////        List<Doctor> list = null;
////        String hql = "from Doctor where skill = :skill and level = :skillLevel";
////        try (Session session = HibernateUtil.getSessionFactory().openSession()) {			
////        	list = session.createQuery(hql).setParameter("skill", skill).setParameter("skillLevel", skillLevel).list();			
////		} catch (Exception e) {
////			e.printStackTrace();
////		}       
////        return list;
////    }
////	
////
////	
////	public static List<Object[]> findDoctors(String skill, String result, LocalDate entryTestDate) {
////        List<Object[]> list = null;
////        String hql = "From Doctor c JOIN c.entryTests e WHERE c.skill = :skill AND e.result = :result AND e.date =:entryTestDate";
////        try (Session session = HibernateUtil.getSessionFactory().openSession()) {			
////        	list = session.createQuery(hql).setParameter("skill", skill).setParameter("result", result).setParameter("entryTestDate", entryTestDate).list();			
////		} catch (Exception e) {
////			e.printStackTrace();
////		}       
////        return list;
////    }
////	
////	public static List<Doctor> pagingDoctors(int pageNumber, int pageSize) {
////		List<Doctor> list = null;
////		
////		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
////			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
////			CriteriaQuery<Doctor> criteriaQuery = criteriaBuilder.createQuery(Doctor.class);
////			Root<Doctor> DoctorRoot = criteriaQuery.from(Doctor.class);
////			criteriaQuery.select(DoctorRoot);
////			list = session.createQuery(criteriaQuery).setFirstResult((pageNumber - 1) * pageSize).setMaxResults(pageSize)
////					.getResultList();
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return list;
////	}
//	
//}
