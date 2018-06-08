package trs.controller;

import trs.data.Comment;
import trs.data.Event;
import trs.data.Poll;
import trs.data.User;

import java.util.Date;

public class EventController {

    private Controller controller;

    public EventController(Controller controller) {
        this.controller = controller;
    }

	public void createEvent(User organisator, Date[] dates, User[] teilnehmer) {
		Poll evt = new Poll();
		evt.setOrganisator(organisator);
		evt.setDates(dates);
		if (teilnehmer != null)
            for (User aTeilnehmer : teilnehmer) evt.addTeilnehmer(aTeilnehmer);
		this.controller.getPollRepo().save(evt);
	}

	public void createEvent(Poll event) {
        if (this.controller.getCurrentUser() != null)
            event.setOrganisator(this.controller.getCurrentUser());
        this.controller.getPollRepo().save(event);
    }

	public void invitePeople(Event evt, User[] teilnehmer) {
        for (User aTeilnehmer : teilnehmer)
            evt.addTeilnehmer(aTeilnehmer);
        this.controller.getPollRepo().save((Poll) evt);
	}

	public void removePeople(Event evt, User teilnehmer) {
		evt.remTeilnehmer(teilnehmer);
		this.controller.getPollRepo().save((Poll) evt);
	}

	public void sendNotification(Event evt) {
    	evt.notifyTeilnehmer();
	}

	public void addDescription(Poll evt, String description) {
		evt.setDescription(description);
		this.controller.getPollRepo().save(evt);
	}

	public void addLocation(Poll evt, String location) {
		evt.setLocation(location);
		this.controller.getPollRepo().save(evt);
	}

	public void setDate(Poll evt, Date date) {
		evt.setDate(date);
		this.controller.getPollRepo().save(evt);
	}

	public void comment(Poll evt, User poster, String text) {
        Comment comment = new Comment();
        comment.setPoster(poster);
        comment.setText(text);
        evt.addComment(comment);
        this.controller.getPollRepo().save(evt);
    }

    public void remove_comment(Poll evt, Comment comment) {
        evt.removeComment(comment);
        this.controller.getPollRepo().save(evt);
    }

}
