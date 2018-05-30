package controller;

import data.Poll;
import data.User;
import data.Event;

import java.util.Date;

public class EventController {
    private Controller controller;

    public EventController(Controller controller) {
        this.controller = controller;
    }

	public void createEvent(User organisator, Date[] dates, User[] teilnehmer) {
		Event evt = new Poll();

	}

	public void invitePeople(Event evt, User[] teilnehmer) {
        for (User aTeilnehmer : teilnehmer)
            evt.addTeilnehmer(aTeilnehmer);
        controller.getSession().persist(evt);
	}

	public void removePeople(Event evt, User teilnehmer) {
		evt.remTeilnehmer(teilnehmer);
		controller.getSession().persist(evt);
	}

	public void sendNotification(Event evt) {
    	evt.notifyTeilnehmer();
		controller.getSession().persist(evt);
	}

	public void addDescription(Poll evt, String description) {
		evt.setDescripition(description);
		controller.getSession().persist(evt);
	}

	public void addLocation(Poll evt, String location) {
		evt.setLocation(location);
		controller.getSession().persist(evt);
	}

	public void setDate(Poll evt, Date date) {
		evt.setDate(date);
		controller.getSession().persist(evt);
	}

}
