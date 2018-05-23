package controller;

import data.User;
import data.Teilnehmer;
import data.Event;

import java.util.Date;

public class EventController {

	public void createEvent(User organisator, Date[] dates, Teilnehmer[] teilnehmer) {

	}

	public void invitePeople(Event evt, User[] teilnehmer) {
		for(int i = 0; i<teilnehmer.length; i++)
			evt.addTeilnehmer(teilnehmer[i]);
	}

	public void removePeople(Event evt, Teilnehmer teilnehmer) {
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
