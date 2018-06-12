package trs.data;

import org.springframework.format.annotation.DateTimeFormat;
import trs.controller.Controller;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Poll implements Event {
    @Id
    @GeneratedValue
    private Long id;

	private Date[] dates;

	private String title;
	private String description;
	private String location;

	@ManyToMany(mappedBy = "events")
	private Set<User> teilnehmer;

	@Transient
	private Controller controller;

	@ElementCollection
	private Set<Comment> comments;

    @ManyToOne
    private User organisator;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
/*
Konstruktor
 */
    public Poll() {
        this.teilnehmer = new HashSet<>();
        this.comments = new HashSet<>();
        this.date = new Date();
    }

	/***
	 * Sets specific date for the Event
	 * @param date
	 */
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

	public Date[] getDates() {
		return dates;
	}

	public void setDates(Date[] dates) {
		this.dates = dates;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    public User getOrganisator() {
        return organisator;
    }

    public void setOrganisator(User organisator) {
        this.organisator = organisator;
    }

    public void addComment(Comment comment) {
	    this.comments.add(comment);
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void removeComment(Comment comment) {
	    this.comments.remove(comment);
    }
}
