package trs.controller;

import trs.data.Comment;
import trs.data.Event;
import trs.data.Poll;
import trs.data.User;

import java.util.Date;

public class EventController {

    private Controller controller;
/*
	Constructor
 */
    public EventController(Controller controller) {
        this.controller = controller;
    }
/*
	@param: Organisator, dates, teilnehmer
	Creates a new event and sets the organisator, the possible dates, adds the teilnehmer and saves the event
 */
	public void createEvent(User organisator, Date[] dates, User[] teilnehmer) {
		Poll evt = new Poll();
		evt.setOrganisator(organisator);
		evt.setDates(dates);
		if (teilnehmer != null)
            for (User aTeilnehmer : teilnehmer) evt.addTeilnehmer(aTeilnehmer);
		this.controller.getPollRepo().save(evt);
	}
/*
	@param: event
	sets the organisator for the event and saves the event
 */
	public void createEvent(Poll event) {
        if (this.controller.getCurrentUser() != null)
            event.setOrganisator(this.controller.getCurrentUser());
        this.controller.getPollRepo().save(event);
    }
/*
	@param: Event, teilnehmer
	adds new teilnehmer to the event and saves the event
 */
	public void invitePeople(Event evt, User[] teilnehmer) {
        for (User aTeilnehmer : teilnehmer)
            evt.addTeilnehmer(aTeilnehmer);
        this.controller.getPollRepo().save((Poll) evt);
	}
/*
	@param: Event, teilnehmer
	removes an existing teilnehmer from the event and saves the event
 */
	public void removePeople(Event evt, User teilnehmer) {
		evt.remTeilnehmer(teilnehmer);
		this.controller.getPollRepo().save((Poll) evt);
	}
/*
	@param: event
	sends a notification to all teilnehmer
 */
	public void sendNotification(Event evt) {
    	evt.notifyTeilnehmer();
	}
/*
	@param: event, description
	adds a new description to the event and saves the event
 */
	public void addDescription(Poll evt, String description) {
		evt.setDescription(description);
		this.controller.getPollRepo().save(evt);
	}
/*
	@param: event, location as a string
	sets the locations from the event and saves the event
 */
	public void addLocation(Poll evt, String location) {
		evt.setLocation(location);
		this.controller.getPollRepo().save(evt);
	}
/*
	@param: event, date
	sets an explicit date for the event and saves the event
 */
	public void setDate(Poll evt, Date date) {
		evt.setDate(date);
		this.controller.getPollRepo().save(evt);
	}
/*
	@param: event, poster, text
	A user can make a comment to an event
 */
	public void comment(Poll evt, User poster, String text) {
        Comment comment = new Comment();
        comment.setPoster(poster);
        comment.setText(text);
        evt.addComment(comment);
        this.controller.getPollRepo().save(evt);
    }

	/*
        @param: event, poster, text
        A user can remove an existing comment to an event
     */
    public void remove_comment(Poll evt, Comment comment) {
        evt.removeComment(comment);
        this.controller.getPollRepo().save(evt);
    }

}
