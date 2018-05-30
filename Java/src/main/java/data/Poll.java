package data;

import controller.Controller;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Poll implements Event {
    @Id
    @GeneratedValue
    private int id;

	private Date[] dates;

	private String descripition;
	private String location;

	@ManyToMany(mappedBy = "events")
	private Set<User> teilnehmer;

	@Transient
	private Controller controller;

	@OneToMany
	private Set<Comment> comments;
	//private Controller controller;

    private Date date;

    public Poll() {
        this.teilnehmer = new HashSet<>();
        this.comments = new HashSet<>();
    }

	public void setDate(Date date) {
	    this.date = date;
	    this.controller.getEventController().setDate(this, date);
	}

	public Date getDate() {
	    return this.date;
    }

/*
    Generated Getters and Setters
*/
	public void addTeilnehmer(User u) {
        this.teilnehmer.add(u);
	}


	public void remTeilnehmer(User u) {
        this.teilnehmer.remove(u);
	}

	public void notifyTeilnehmer() {
        for (IUser t: teilnehmer)
            t.notify_User(this);
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
}
