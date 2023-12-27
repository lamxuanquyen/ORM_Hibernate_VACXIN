/**
 * 
 */
package fa.trainning.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "employee")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "emp_name")
	private String name;

	@Column
	private String gender;

	@Column
	private String address;

	@Column
	private String phone;

	@Column(name = "exp_year")
	private int expYear;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<History> histories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public Set<History> getHistories() {
		return histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	public Employee() {
	}

	public Employee(String name, String gender, String address, String phone, int expYear) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.expYear = expYear;
	}

	public Employee(int id, String name, String gender, String address, String phone, int expYear,
			Set<History> histories) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.expYear = expYear;
		this.histories = histories;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", phone="
				+ phone + ", expYear=" + expYear + "]";
	}

}
