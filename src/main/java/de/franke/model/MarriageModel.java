package de.franke.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MarriageModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	

}
