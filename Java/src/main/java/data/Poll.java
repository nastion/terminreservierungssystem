package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Poll implements Event {

    @Id
    @GeneratedValue
    private int id;
	private Date[] dates;
	private Teilnehmer organisator;

	private String descripition = null;
	private String location = null;
	private User user = null;
	//private Controller controller;


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

	public Date[] getDates() {
		return dates;
	}

	public void setDates(Date[] dates) {
		this.dates = dates;
	}

	public Teilnehmer getOrganisator() {
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
