/**
 * 
 */
package fa.trainning.entities;

import java.time.LocalDate;
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
@Table(name = "customer")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "birthday")
	private LocalDate birthday;

	@Column
	private String address;

	@Column
	private String phone;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<History> histories;

//	@ManyToOne
//	@JoinColumn(name = "pat_id")
//	private Patient patient;

//	@ManyToOne
//	@JoinColumn(name = "bill_id")
//	private Bill bill;

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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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

	public Set<History> getHistories() {
		return histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	public Customer() {
	}

	public Customer(String name, String gender, LocalDate birthday, String address, String phone) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
	}

	public Customer(int id, String name, String gender, LocalDate birthday, String address, String phone,
			Set<History> histories) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.histories = histories;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", address="
				+ address + ", phone=" + phone + "]";
	}

}
