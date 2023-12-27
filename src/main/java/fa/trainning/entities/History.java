/**
 * 
 */
package fa.trainning.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "history")

public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@ManyToOne
	@JoinColumn(name = "cus_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "vac_id")
	private Vaccin vaccin;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column
	private LocalDate date;

	@Column
	private String status;

	@Column
	private Double sumAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Vaccin getVaccin() {
		return vaccin;
	}

	public void setVaccin(Vaccin vaccin) {
		this.vaccin = vaccin;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	}

	public History() {
	}

	public History(int id, Customer customer, Employee employee, Vaccin vaccin, Brand brand, LocalDate date,
			String status, Double sumAmount) {
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.vaccin = vaccin;
		this.brand = brand;
		this.date = date;
		this.status = status;
		this.sumAmount = sumAmount;
	}

	public History(Customer customer, Employee employee, Vaccin vaccin, Brand brand, LocalDate date, String status,
			double sumAmount) {
		this.customer = customer;
		this.employee = employee;
		this.vaccin = vaccin;
		this.brand = brand;
		this.date = date;
		this.status = status;
		this.sumAmount = sumAmount;
	}

	public History(Customer customer, Employee employee, String status) {
		this.customer = customer;
		this.employee = employee;
		this.status = status;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", customer=" + customer + ", employee=" + employee + ", vaccin=" + vaccin
				+ ", brand=" + brand + ", date=" + date + ", status=" + status + ", sumAmount=" + sumAmount + "]";
	}

}
