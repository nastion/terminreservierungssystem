package controller;

import data.User;
import data.Event;

import java.util.Date;

public class EventController {
    private Controller controller;

    public EventController(Controller controller) {
        this.controller = controller;
    }

	public void createEvent(User organisator, Date[] dates, User[] teilnehmer) {

	}

	public void invitePeople(Event evt, User[] teilnehmer) {
        for (User aTeilnehmer : teilnehmer)
            evt.addTeilnehmer(aTeilnehmer);
        controller.getSession().persist(evt);
	}

	public void removePeople(Event evt, User teilnehmer) {
		evt.remTeilnehmer(teilnehmer);
	}

	public void sendNotification(Event evt) {
		evt.notifyTeilnehmer();
	}

	public void addDescription(Event evt, String description) {

	}

	public void addLocation(Event evt, String location) {

	}

	public void setDate(Event evt, Date date) {

	}

}
