package data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Organisator extends User {
	private Poll poll;

    //private Controller controller;

	public Organisator(User user, Poll event) {
	    super(user.getName(), user.getPassword());
	    this.poll = event;
    }

	public void setDate(Date date) {
        this.poll.setDate(date);
	}
}
