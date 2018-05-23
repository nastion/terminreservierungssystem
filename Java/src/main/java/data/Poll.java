package data;

import controller.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Poll implements Event {

    @Id
    @GeneratedValue
    private int id;
	private Date dates;
	private User organisator;

	private String descripition = null;
	private String location = null;
	private User user = null;
	private Controller controller;


	public Poll(Date dates, User organisator, String descripition, String location, User user) {
		this.dates = dates;
		this.organisator = organisator;
		this.descripition = descripition;
		this.location = location;
		this.user = user;
	}

	public void setDate(Date date) {

	}

/*
    Generated Getters and Setters
*/
	public void addTeilnehmer(User u) {

	}


	public void remTeilnehmer(User t) {

	}


	public void notifyTeilnehmer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public User getOrganisator() {
		return organisator;
	}

	public void setOrganisator(Teilnehmer organisator) {
		this.organisator = organisator;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
