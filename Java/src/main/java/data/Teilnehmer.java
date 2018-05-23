package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teilnehmer implements User {
	@Id
	@GeneratedValue
	private Poll poll;

	private String name;
	private String password = null;
	//private Controller controller;
	private Notification notification = null;


	public Teilnehmer(String name, String password, Notification notification) {
		this.name = name;
		this.password = password;
		this.notification = notification;
	}


	public void notify_User() {

	}

/*
	Generated Getters and Setters
 */
	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
}
