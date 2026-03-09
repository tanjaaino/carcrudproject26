package hh.sof03.carcrudproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	// attribuutit

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; // new attribute id

	private String brand;

	@Column(name="production_year")
	private int year;
	
	//konstruktorit
	public Car() {
		super();
		this.id = null;
		this.brand = null;
		this.year = 0;
	}
	public Car(String brand, int year) {
		super();
		this.brand = brand;
		this.year = year;
	}
	
	public Car(Long id, String brand, int year) {
		super();
		this.id = id;
		this.brand = brand;
		this.year = year;
	}
	//setterit
	public void setId(Long id) {
		this.id = id;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setYear(int year) {
		this.year = year;
	}
	// getterit
	public String getBrand() {
		return brand;
	}
	public int getYear() {
		return year;
	}
	
	public Long getId() {
		return id;
	}
	// toString	
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", year=" + year + "]";
	}
	

}
