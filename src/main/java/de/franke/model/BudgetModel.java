package de.franke.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BudgetModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UserModel user;
	private String topic;
	private String name;
	private float plannedValue;
	private float realValue;
	private Boolean paid;

	public BudgetModel() {
		// TODO Auto-generated constructor stub
	}

	public BudgetModel(String topic ,String name, float plannedValue, float realValue, Boolean paid, UserModel user) {
		this.topic = topic;
		this.name = name;
		this.plannedValue = plannedValue;
		this.realValue = realValue;
		this.paid = paid;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPlannedValue() {
		return plannedValue;
	}

	public void setPlannedValue(float plannedValue) {
		this.plannedValue = plannedValue;
	}

	public float getRealValue() {
		return realValue;
	}

	public void setRealValue(float realValue) {
		this.realValue = realValue;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "BudgetModel [id=" + id + ", user=" + user + ", topic=" + topic + ", name=" + name + ", plannedValue="
				+ plannedValue + ", realValue=" + realValue + ", paid=" + paid + "]";
	}

	
	
}