package com.vigo.dali.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the cars database table.
 * 
 */
@Entity
@Table(name = "cars")
@NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	private String brand;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Id", unique = true)
	private Integer id;

	private String interior;

	private String model;

	@Column(name = "new_state")
	private Boolean newState;

	@Column(name = "year_production")
	private Integer yearProduction;

	public Car() {
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInterior() {
		return this.interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getNewState() {
		return this.newState;
	}

	public void setNewState(Boolean newState) {
		this.newState = newState;
	}

	public Integer getYearProduction() {
		return this.yearProduction;
	}

	public void setYearProduction(Integer yearProduction) {
		this.yearProduction = yearProduction;
	}

}