package de.franke.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	private String userName;
	private String password;
	private String futureLastName;
	private String marriagePartner;
	@OneToMany(mappedBy = "user")
	private List<BudgetModel> budget;

	protected UserModel() {
	}

	public UserModel(String firstName, String lastName,
			String userName, String password, String futureLastName,
			String marriagePartner) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.futureLastName = futureLastName;
		this.marriagePartner = marriagePartner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getFutureLastName() {
		return futureLastName;
	}

	public void setFutureLastName(String futureLastName) {
		this.futureLastName = futureLastName;
	}

	public String getMarriagePartner() {
		return marriagePartner;
	}

	public void setMarriagePartner(String marriagePartner) {
		this.marriagePartner = marriagePartner;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", futureLastName="
				+ futureLastName + ", marriagePartner=" + marriagePartner + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<BudgetModel> getBudget() {
		return budget;
	}

	public void setBudget(List<BudgetModel> budget) {
		this.budget = budget;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
}
