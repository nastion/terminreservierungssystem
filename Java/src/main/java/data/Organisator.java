package data;

import controller.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
public class Organisator extends User {
	@Id
	@GeneratedValue
	private Poll poll;

	private Controller controller;

    //private Controller controller;

	public Organisator(Controller controller, Poll event) {
	    this.controller = controller;
	    this.poll = event;
	}

	public void setDate(Date date) {
        controller.getEventController().setDate(this.poll, date);
	}
}
