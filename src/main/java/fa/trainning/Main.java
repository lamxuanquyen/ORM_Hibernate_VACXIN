package fa.trainning;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fa.trainning.dao.VaccinDao;
import fa.trainning.utils.HibernateUtil;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VaccinDao addOnDao = new VaccinDao();
		try (SessionFactory sf = HibernateUtil.getSessionFactory(); Session session = sf.openSession()) {
			addOnDao.initDB(session);
//			System.out.println("ok");
			int choice = -1;
			do {
				System.out.println("=====MANAGEMENT SYSTEM=====");
				System.out.println("0. Exit");
				System.out.println("1. Show all check-in customers");
				System.out.println("2. Assign employee");
				System.out.println("3. Finish vaccination");
				System.out.print("Please choose function you'd like to do:");
				try {
					choice = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format");
					continue;
				}
				switch (choice) {
				case 1:
					addOnDao.findCustomerCheckIn(session);
					break;
				case 2:
					addOnDao.assignEmployee(session);
				case 3:
					addOnDao.finishVaccination(session);
					break;
				case 0:
					System.out.println("Exit program");
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice != 0);

		}
	}

}
