package trs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trs.data.User;
import trs.repositories.PollRepository;
import trs.repositories.UserRepository;

@Component
public class Controller {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PollRepository pollRepo;

    private User currentUser;

	private EventController eventController;

	private UserController userController;
/*
    constructor
 */
	public Controller() {
	    this.setUserController(new UserController(this));
        this.setEventController(new EventController(this));
    }

    /***
     *
     * @return  the logged User
     */
	public User getCurrentUser() {
	    return this.currentUser;
    }


    /***
     * Sets the @param: User as the currentUser
     * @param currentUser
     * @return true
     */
     public boolean setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        return true;
    }
/*
    Generated Getter/Setter
 */
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

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public PollRepository getPollRepo() {
        return pollRepo;
    }

    public void setPollRepo(PollRepository pollRepo) {
        this.pollRepo = pollRepo;
    }

}
