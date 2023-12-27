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
@Table(name = "brand")

public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "brand_name")
	private String name;

	@Column(name = "brand_address")
	private String address;

	@Column(name = "brand_phone")
	private String phone;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
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

	public Brand() {
	}

	public Brand(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Brand(int id, String name, String address, String phone, Set<History> histories) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.histories = histories;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", histories="
				+ histories + "]";
	}

}
