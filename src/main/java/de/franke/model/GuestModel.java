package de.franke.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Email;

@Entity
public class GuestModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String street;
	private String postalCode;
	private String town;
	private String email;
	private String marriageSide;
	private Boolean invited;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UserModel user;
	
	public GuestModel() {
	}
	public GuestModel(long id, String firstName, String lastName,
			String street, String postalCode, String town, String email,
			String marriageSide, Boolean invited) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.postalCode = postalCode;
		this.town = town;
		this.email = email;
		this.marriageSide = marriageSide;
		this.invited = invited;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMarriageSide() {
		return marriageSide;
	}
	public void setMarriageSide(String marriageSide) {
		this.marriageSide = marriageSide;
	}
	public Boolean getInvited() {
		return invited;
	}
	public void setInvited(Boolean invited) {
		this.invited = invited;
	}
	
	
}
