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


	public void addTeilnehmer(User u) {

	}


	public void remTeilnehmer(User t) {

	}


	public void notifyTeilnehmer() {

	}

}
