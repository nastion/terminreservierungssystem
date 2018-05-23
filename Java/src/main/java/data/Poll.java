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


	public void setDate(Date date) {

	}


	public void addTeilnehmer(User u) {

	}


	public void remTeilnehmer(User t) {

	}


	public void notifyTeilnehmer() {

	}

}
