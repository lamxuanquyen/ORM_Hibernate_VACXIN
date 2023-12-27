/**
 * 
 */
package fa.trainning.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.trainning.dao.PaymentDao;
import fa.trainning.entities.Customer;

/**
 * @author Administrator
 *
 */
public class PaymentDao {


	public Customer getPayment(Session session, int id) {
		Customer payment = null;
		payment = session.get(Customer.class, id);
		if (payment == null) {
			System.out.println("No payment found with id = " + id);
		}
		return payment;
	}


	public void updatePaymentMethod(Session session, int id, String method) {
		Customer payment = getPayment(session, id);
		if (payment == null) {
			return;
		}
		System.out.println("Info of the payment before update: " + payment);
//		payment.setMethod(method);
		updatePayment(session, payment);
		System.out.println("Info of the payment after update: " + getPayment(session, id));
	}


	public void deletePayment(Session session, int id) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.clear();
			Customer payment = getPayment(session, id);

			if (payment == null) {
				return;
			}
			System.out.println("Info of the payment before delete: " + payment);
			session.delete(payment);

			transaction.commit();
			getPayment(session, id);

		} catch (Exception e) {
			System.out.println("Delete failed");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	public void savePayment(Session session, Customer payment) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(payment);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Insert failed");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	public void updatePayment(Session session, Customer payment) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(payment);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Update failed");
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unchecked")
	public List<Customer> showAllPayments(Session session) {
		String hql = "FROM Payment";
		List<Customer> list = session.createQuery(hql).list();
		list.forEach(t -> System.out.println(t.toString()));
		return list;
	}

}
