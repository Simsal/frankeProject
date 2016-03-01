package de.franke.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProviderModel {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String street;
	private String postalCode;
	private String town;
	private String email;
	private String telephone;
	private String mobilephone;
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UserModel user;
	
	public ProviderModel() {
		// TODO Auto-generated constructor stub
	}

	public ProviderModel(String name, String street, String postalCode,
			String town, String email, String telephone, String mobilephone,
			String comment, UserModel user) {
		super();
		this.name = name;
		this.street = street;
		this.postalCode = postalCode;
		this.town = town;
		this.email = email;
		this.telephone = telephone;
		this.mobilephone = mobilephone;
		this.comment = comment;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ProviderModel [id=" + id + ", name=" + name + ", street="
				+ street + ", postalCode=" + postalCode + ", town=" + town
				+ ", email=" + email + ", telephone=" + telephone
				+ ", mobilephone=" + mobilephone + ", comment=" + comment + "]";
	}
	

}
