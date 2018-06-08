package trs.controller;

import trs.data.User;

public class UserController {
	private Controller controller;

	public UserController(Controller controller) {
	    this.controller = controller;
    }
	/*
		@param: String username, String password
		@return: user/null

<<<<<<< HEAD
		User login needs username and a password, the function tries to find the user in the UserRepo
		if the username exists, the password will be checked too. if the password fits the username the User is set as the current User
	 */
	public User login(String username, String password) {
=======
	public boolean login(String username, String password) {
>>>>>>> 9a62b0254124b986c8abc9eadc7f044c34f95ff5
		User logUser = this.controller.getUserRepo().findUserByName(username);
		if(logUser != null && logUser.getPassword().equals(password)) {
			controller.setCurrentUser(logUser);
			return true;
		}
		controller.setCurrentUser(null);
		return false;
	}
	/*
		@param: username, password
		@return user
		Creates new UserObject and calls createUser methode
	 */
	public boolean createUser(String username, String password) {
		User user = new User(username, password);
		return this.createUser(user);
	}
	/*
		@param: User
		@return: boolean
		Checks if a User with the same Username already exist
		if the Username is unique the User will be saved and returns true
	 */
	public boolean createUser(User user) {
	    if (this.controller.getUserRepo().findUserByName(user.getName()) == null) {
	        this.controller.getUserRepo().save(user);
            return true;
	    }
	    return false;
    }

    /*
    	@param username
    	@return user/null
    	Checks if a User with this username exists
     */
	public User searchUser(String username) {
		return this.controller.getUserRepo().findUserByName(username);
	}
	/*
		@return null
		Sets current User to NULL
	 */
	public boolean logout() {
		return this.controller.setCurrentUser(null);
	}

}
