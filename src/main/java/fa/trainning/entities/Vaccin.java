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
@Table(name = "vaccin")

public class Vaccin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "vaccin_name")
	private String name;

	@Column
	private String country;

	@Column(name = "product_date")
	private LocalDate productDate;

	@Column
	private double price;

	@OneToMany(mappedBy = "vaccin", cascade = CascadeType.ALL)
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getProductDate() {
		return productDate;
	}

	public void setProductDate(LocalDate productDate) {
		this.productDate = productDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<History> getHistories() {
		return histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	public Vaccin() {
	}

	public Vaccin(String name, String country, LocalDate productDate, double price) {
		this.name = name;
		this.country = country;
		this.productDate = productDate;
		this.price = price;
	}

	public Vaccin(int id, String name, String country, LocalDate productDate, double price, Set<History> histories) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.productDate = productDate;
		this.price = price;
		this.histories = histories;
	}

	@Override
	public String toString() {
		return "Vaccin [id=" + id + ", name=" + name + ", country=" + country + ", productDate=" + productDate
				+ ", price=" + price + "]";
	}

}
