package controller;

import data.User;
import data.Event;
import org.hibernate.Session;

public class Controller {
    private User currentUser;

	private EventController eventController;

	private UserController userController;

	public User getCurrentUser() {
	    return this.currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public EventController getEventController() {
        return eventController;
    }

    public void setEventController(EventController eventController) {
        this.eventController = eventController;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

}
