/**
 * 
 */
package fa.trainning.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.trainning.dao.VaccinDao;
import fa.trainning.entities.Brand;
import fa.trainning.entities.Customer;
import fa.trainning.entities.Employee;
import fa.trainning.entities.History;
import fa.trainning.entities.Vaccin;
import fa.trainning.utils.Input;

/**
 * @author Administrator
 *
 */
public class VaccinDao {
	public static void initDB(Session session) {
		Vaccin vaccin1 = new Vaccin("6 in 1", "VietNam", LocalDate.of(2023, 01, 01), 100000);
		Vaccin vaccin2 = new Vaccin("Quai bi", "Anh", LocalDate.of(2023, 01, 01), 200000);
		Vaccin vaccin3 = new Vaccin("Viem nao nhat ban", "Nhat Ban", LocalDate.of(2023, 01, 01), 300000);
		Vaccin vaccin4 = new Vaccin("Thuy dau", "Bi", LocalDate.of(2023, 01, 01), 400000);
		Vaccin vaccin5 = new Vaccin("Cum", "Ha Lan", LocalDate.of(2023, 01, 01), 500000);

		Brand brand1 = new Brand("Ha Noi", "Ha Noi", "0123456789");
		Brand brand2 = new Brand("Hue", "Hue", "0123456789");
		Brand brand3 = new Brand("Da Nang", "Da Nang", "0123456789");
		Brand brand4 = new Brand("Binh Dinh", "Binh Dinh", "0123456789");
		Brand brand5 = new Brand("TPHCM", "TPHCM", "0123456789");

		Customer customer1 = new Customer("Customer A", "Male", LocalDate.of(1990, 01, 01), "Address 1", "0123456789");
		Customer customer2 = new Customer("Customer B", "Female", LocalDate.of(1990, 01, 01), "Address 2",
				"0123456789");
		Customer customer3 = new Customer("Customer C", "Male", LocalDate.of(2020, 01, 01), "Address 3", "0123456789");
		Customer customer4 = new Customer("Customer D", "Female", LocalDate.of(2010, 01, 01), "Address 4",
				"0123456789");
		Customer customer5 = new Customer("Customer E", "Male", LocalDate.of(1990, 01, 01), "Address 5", "0123456789");

		Employee employee1 = new Employee("Employee 1", "Female", "Address", "0111111111", 1);
		Employee employee2 = new Employee("Employee 2", "Male", "Address", "0111111111", 2);
		Employee employee3 = new Employee("Employee 3", "Female", "Address", "0111111111", 3);
		Employee employee4 = new Employee("Employee 4", "Male", "Address", "0111111111", 4);
		Employee employee5 = new Employee("Employee 5", "Female", "Address", "0111111111", 5);

		History history1 = new History(customer1, employee1, vaccin1, brand1, LocalDate.now(), "Da tiem", 100000);
		History history2 = new History(customer2, employee2, vaccin2, brand2, LocalDate.of(2023, 01, 01), null, 200000);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(vaccin1);
			session.saveOrUpdate(vaccin2);
			session.saveOrUpdate(vaccin3);
			session.saveOrUpdate(vaccin4);
			session.saveOrUpdate(vaccin5);

			session.saveOrUpdate(brand1);
			session.saveOrUpdate(brand2);
			session.saveOrUpdate(brand3);
			session.saveOrUpdate(brand4);
			session.saveOrUpdate(brand5);

			session.saveOrUpdate(customer1);
			session.saveOrUpdate(customer2);
			session.saveOrUpdate(customer3);
			session.saveOrUpdate(customer4);
			session.saveOrUpdate(customer5);

			session.saveOrUpdate(employee1);
			session.saveOrUpdate(employee2);
			session.saveOrUpdate(employee3);
			session.saveOrUpdate(employee4);
			session.saveOrUpdate(employee5);

			session.saveOrUpdate(history1);
			session.saveOrUpdate(history2);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Insert failed");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}



	public static List<Customer> findCustomerCheckIn(Session session) {
		LocalDate currentDate = LocalDate.now();
		String hql = "SELECT c FROM Customer c LEFT JOIN c.histories h WHERE h.date !=:currentDate OR h.date is null";
		List<Customer> list = null;
		list = session.createQuery(hql).setParameter("currentDate", currentDate).list();
		if (list == null || list.size() == 0) {
			System.out.println("Hien tai khong co khach hang nao dang cho check in");
		} else {
			System.out.println("Danh sach khach hang dang cho check-in");
			list.forEach(t -> System.out.println(((Customer) t).toString()));
		}
		return list;
	}


	public static void assignEmployee(Session session) {
		List<Customer> list = findCustomerCheckIn(session);
		if (list == null || list.size() == 0) {
			return;
		}
		int cusID = Input.inputInt("Input the customer ID that wants to be assigned to vaccination");
		Customer customer = session.get(Customer.class, cusID);
		if (customer == null) {
			System.out.println("Invalid customer ID");
			return;
		}
		if (!list.contains(customer)) {
			System.out.println("Khach hang da tiem, vui long chon khach hang khac");
			return;
		}

		int empID = Input.inputInt("Input the employee ID that wants to assign to vaccination");
		Employee employee = session.get(Employee.class, empID);
		if (employee == null) {
			System.out.println("Invalid employee ID");
			return;
		}
		if (!checkEmployee(customer, employee)) {
			return;
		}
		History history = new History(customer, employee, "Cho tiem");
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(history);
			transaction.commit();
			System.out.println("Assign the employee successfully");
		} catch (Exception e) {
			System.out.println("Assign the employee failed");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public  static boolean checkEmployee(Customer customer, Employee employee) {
		LocalDate currrentDay = LocalDate.now();
		if (((currrentDay.getYear() - customer.getBirthday().getYear()) <= 6) && employee.getExpYear() < 3) {
			System.out.println("Nhan vien chua du so nam kinh nghiem. De nghi phan cong nhan vien khac");
			return false;
		}
		return true;
	}


	public static void finishVaccination(Session session) {
		List<Customer> list = findCustomerWaitingVaccination(session);
		if (list == null || list.size() == 0) {
			return;
		}
		int cusID = Input.inputInt("Input customer ID that wants to be finished vaccination");
		Customer customer = session.get(Customer.class, cusID);
		if (customer == null) {
			System.out.println("Invalid customer ID");
			return;
		}
		if (!list.contains(customer)) {
			System.out.println("Khach hang dang khong cho tiem, vui long chon khach hang khac");
			return;
		}

		History history = findHistoryByCustomer(session, cusID);
		if (history == null) {
			System.out.println("Chua co lich su tiem chung. Vui long tao lich su tiem chung truoc");
			return;
		}
		int vaccinID = -1;
		do {
			vaccinID = Input.inputInt("Input vaccin ID (from 0-5)");
		} while (vaccinID < 0 || vaccinID > 5);
		Vaccin vaccin = session.get(Vaccin.class, vaccinID);
		int age = LocalDate.now().getYear() - customer.getBirthday().getYear();
		double sumAmount = vaccin.getPrice();
		if (age < 6) {
			sumAmount = sumAmount * 0.9;
		}
		if (age >= 6 && age <= 18) {
			sumAmount = sumAmount * 0.95;
		}
		history.setDate(LocalDate.now());
		history.setStatus("Da tiem");
		history.setVaccin(vaccin);
		history.setSumAmount(sumAmount);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(history);
			transaction.commit();
			System.out.println("Finish vaccination successfully");
		} catch (Exception e) {
			System.out.println("Finish vaccination failed");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	public static List<Customer> findCustomerWaitingVaccination(Session session) {
		String hql = "SELECT c FROM Customer c JOIN c.histories h WHERE h.status LIKE :status";
		List<Customer> list = null;
		list = session.createQuery(hql).setParameter("status", "%" + "Cho tiem" + "%").list();
		if (list == null || list.size() == 0) {
			System.out.println("Hien tai khong co khach hang nao dang cho tiem");
		} else {
			System.out.println("Danh sach khach hang dang cho tiem");
			list.forEach(t -> System.out.println(((Customer) t).toString()));
		}
		return list;
	}

	public static History findHistoryByCustomer(Session session, int cusID) {
		String hql = "SELECT h FROM History h JOIN h.customer c WHERE c.id =:customerID AND h.status ='Cho tiem'";
		History history = (History) (session.createQuery(hql).setParameter("customerID", cusID).uniqueResult());
		return history;
	}
}
