package trs.controller;

import trs.data.User;

public class UserController {
	private Controller controller;

	public UserController(Controller controller) {
	    this.controller = controller;
    }

    /***
     * User login needs username and a password, the function tries to find the user in the UserRepo
     * f the username exists, the password will be checked too. if the password fits the username the User is set as the current User
     * @param username
     * @param password
     * @return logUser
     * @return null
     */
	public User login(String username, String password) {
		User logUser = this.controller.getUserRepo().findUserByName(username);
		if(logUser != null && logUser.getPassword().equals(password)) {
			controller.setCurrentUser(logUser);
			return logUser;
		}
		controller.setCurrentUser(null);
		return null;
	}

    /***
     * Creates new UserObject and calls createUser methode
     * @param username
     * @param password
     * @return user
     */
	public boolean createUser(String username, String password) {
		User user = new User(username, password);
		return this.createUser(user);
	}

    /***
     * Checks if a User with the same Username already exist
     * 		if the Username is unique the User will be saved and returns true
     * @param user
     * @return boolean
     */
	public boolean createUser(User user) {
	    if (this.controller.getUserRepo().findUserByName(user.getName()) == null) {
	        this.controller.getUserRepo().save(user);
            return true;
	    }
	    return false;
    }

    /***
     * Checks if a User with this username exists
     * @param username
     * @return user
     */
	public User searchUser(String username) {
		return this.controller.getUserRepo().findUserByName(username);
	}

    /***
     *  logs out the user
     * @return boolean
     */
	public boolean logout() {
		return this.controller.setCurrentUser(null);
	}

}
